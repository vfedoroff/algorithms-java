package hackerrank;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class RestApiTest {
    class Page {
        @SerializedName("total_pages")
        public Integer totalPages;
        @SerializedName("data")
        public Game[] data;

    }

    class Game {
        @SerializedName("team1goals")
        public Integer team1Goals;
        @SerializedName("team2goals")
        public Integer team2Goals;
    }

    class HackerRankClient {
        final private CloseableHttpClient httpClient;
        final private Gson gson;

        public HackerRankClient(CloseableHttpClient client) {
            this.httpClient = client;
            this.gson = new Gson();
        }

        public Page getMatches(Integer pageNumber, Integer year, String team1, String team2) throws IOException {
            Page result;
            String apiURl = String.format("https://jsonmock.hackerrank.com/api/football_matches?year=%d", year);
            if (team1 != null) {
                apiURl = String.format("%s&team1=%s", apiURl, team1);
            }
            if (team2 != null) {
                apiURl = String.format("%s&team2=%s", apiURl, team2);
            }
            if (pageNumber != null && pageNumber > 0) {
                apiURl = String.format("%s&page=%s", apiURl, pageNumber);
            }
            HttpGet request = new HttpGet(apiURl);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                Reader reader = new InputStreamReader(response.getEntity().getContent());
                result = gson.fromJson(reader, Page.class);
            }
            return result;
        }
    }

    @Test
    void testRestApi() throws IOException {
        // 5 seconds timeout
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(5000)
                .build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(100);
        HttpClientBuilder httpClientBuilder = HttpClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig);
        ArrayList<CompletableFuture<Integer>> futures = new ArrayList<>();
        try (CloseableHttpClient httpClient = httpClientBuilder.build()) {
            HackerRankClient client = new HackerRankClient(httpClient);
            CompletableFuture<Void> team1Processor =  CompletableFuture.runAsync(() -> {
                try {
                    Integer totalPages;
                    Page currentPage = client.getMatches(1, 2011, "Barcelona", null);
                    final Integer totalGoals = Arrays.stream(currentPage.data).map(x -> x.team1Goals).reduce(Integer::sum).orElse(0);
                    futures.add(CompletableFuture.supplyAsync(() -> totalGoals));
                    totalPages = currentPage.totalPages;
                    for (int i = 2; i < totalPages; i++) {
                        Integer finalPage = i;
                        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                            Integer result = 0;
                            try {
                                final Page matches = client.getMatches(finalPage, 2011, "Barcelona", null);
                                result = Arrays.stream(matches.data).map(x -> x.team1Goals).reduce(Integer::sum).orElse(0);
                            } catch (IOException e) {
                            }
                            return result;
                        });
                        futures.add(future);
                    }
                } catch (IOException e){}
            });
            CompletableFuture<Void> team2Processor =  CompletableFuture.runAsync(() -> {
                try {
                    Integer totalPages = null;
                    Page currentPage = client.getMatches(1, 2011, null, "Barcelona");
                    final Integer totalGoals = Arrays.stream(currentPage.data).map(x -> x.team1Goals).reduce(Integer::sum).orElse(0);
                    futures.add(CompletableFuture.supplyAsync(() -> totalGoals));
                    totalPages = currentPage.totalPages;
                    for (int i = 2; i < totalPages; i++) {
                        Integer finalPage = i;
                        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                            Integer result = 0;
                            try {
                                final Page matches = client.getMatches(finalPage, 2011, null, "Barcelona");
                                result = Arrays.stream(matches.data).map(x -> x.team2Goals).reduce(Integer::sum).orElse(0);

                            } catch (IOException e) {
                            }
                            return result;
                        });
                        futures.add(future);
                    }
                } catch (IOException e){}
            });

            CompletableFuture<Void> waitProcessorFutures = CompletableFuture.allOf(team1Processor, team2Processor);
            CompletableFuture<Integer> result = waitProcessorFutures.thenApply(
                    c -> {
                        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
                        CompletableFuture<List<Integer>> goalsFuture = allFutures.thenApply(v ->
                                futures.stream()
                                        .map(CompletableFuture::join).collect(Collectors.toList())
                        );
                         return goalsFuture.thenApply(g -> g.stream().reduce(Integer::sum).orElse(0)).join();
                    });
            System.out.println(result.join());
        }
    }
}
