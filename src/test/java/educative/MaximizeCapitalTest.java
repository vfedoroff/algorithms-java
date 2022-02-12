package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximizeCapitalTest {

    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, Collections.reverseOrder());
        // insert all project capitals to a min-heap
        for (int c : capital) {
            minCapitalHeap.offer(c);
        }
        // let's try to find a total of 'numberOfProjects' best projects
        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            // find all projects that can be selected within the available capital and insert them in a max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek() <= availableCapital)
                maxProfitHeap.add(minCapitalHeap.poll());
            // terminate if we are not able to find any project that can be completed within the available capital
            if (maxProfitHeap.isEmpty())
                break;
            // select the project with the maximum profit
            availableCapital += profits[maxProfitHeap.poll()];
        }
        return availableCapital;
    }

    @Test
    void test(){
        Assertions.assertEquals(6 ,findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1));
    }
}
