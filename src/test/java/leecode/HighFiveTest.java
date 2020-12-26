package leecode;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HighFiveTest {
    class Solution {
        public int[][] highFive(int[][] items) {
            TreeMap<Integer, Queue<Integer>> students = new TreeMap<>();
            for (int[] item : items) {
                int id = item[0];
                int score = item[1];
                if (!students.containsKey(id)) {
                    Queue<Integer> scores = new PriorityQueue<>((a, b) -> b - a);
                    students.put(id, scores);
                }
                students.get(id).offer(score);
            }
            List<int[]> output = new ArrayList<>();
            for (int id : students.keySet()) {
                int sum = 0;
                for (int i = 0; i < 5; i++) {
                    sum += students.get(id).poll();
                }
                output.add(new int[]{id, sum / 5});
            }
            return output.stream().toArray(int[][]::new);
        }
    }

    @Test
    void testHighFive() {
        int[][] items;
        int[][] expected;
        items = new int[][]{
                {1, 91},
                {1, 92},
                {2, 93},
                {2, 97},
                {1, 60},
                {2, 77},
                {1, 65},
                {1, 87},
                {1, 100},
                {2, 100},
                {2, 76}};
        Solution solution = new Solution();
        Instant start = Instant.now();
        int[][] actual = solution.highFive(items);
        Instant finish = Instant.now();
        expected = new int[][]{{1, 87}, {2, 88}};
        assertArrayEquals(expected, actual);
        System.out.printf("Execution: %d ms\n", Duration.between(start, finish).toMillis());
    }
}

