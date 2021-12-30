package educative;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.concurrent.*;

public class FutureTest {

    @Test
    void testAsync() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        new Thread(()->{
            System.out.println("Thread");
        }).start();

        executor.execute(()->{
            System.out.println(LocalTime.now());
        });

        CompletableFuture<Void> future = CompletableFuture.runAsync(()-> {
            System.out.println(LocalTime.now());
        }, executor);
        future.join();
        CompletableFuture<String> strFuture = CompletableFuture.supplyAsync(()->{
            return String.valueOf(LocalTime.now());
        }, executor);
        System.out.println(strFuture.get());

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(()-> {
            System.out.println(LocalTime.now());
            throw new RuntimeException("Boom");
        }, executor);
        cf.exceptionally(ex->{
           System.out.println(ex.toString());
            return "exception";
        });
        try {
            System.out.println(cf.join());
        } catch (CompletionException e){}
    }
}
