package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MaximumCPULoadTest {
    class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    };

    public static int findMaxCPULoad(List<Job> jobs) {
        Collections.sort(jobs, (a,b)->Integer.compare(a.start, b.start));
        int maxCPULoad = 0;
        int currentCPULoad = 0;
        PriorityQueue<Job> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        for (Job job : jobs){
            while (!queue.isEmpty() && job.start >= queue.peek().end)
                currentCPULoad -= queue.poll().cpuLoad;
            queue.offer(job);
            currentCPULoad += job.cpuLoad;
            maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
        }
        return maxCPULoad;
    }

    @Test
    void testFindMaxCPULoad(){
        List<Job> input = new ArrayList<Job>(){
            {
                add(new Job(1, 4, 3));
                add(new Job(2, 5, 4));
                add(new Job(7, 9, 6));
            }
        };
        Assertions.assertEquals(7, findMaxCPULoad(input));
    }
}
