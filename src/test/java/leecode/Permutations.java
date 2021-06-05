package leecode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class Permutations {

    private static Logger log = Logger.getAnonymousLogger();

    class Solution {

        private void generate(int k, List<Integer> a, List<List<Integer>> output){
            if (k == 1) {
                output.add(new ArrayList<>(a));
                return;
            }
            for (int i = 0; i < k-1; ++i) {
                generate(k -1, a, output);

                // Swap choice dependent on parity of k (even or odd)
                if (k % 2 == 0){
                    Collections.swap(a, i, k - 1);
                } else {
                    Collections.swap(a, 0, k - 1);
                }
            }
            generate(k -1, a, output);
        }

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> a = new ArrayList<>();
            // We do "boxing"
            for (int n : nums) {
                a.add(n);
            }
            List<List<Integer>> output = new ArrayList<List<Integer>>();
            generate(a.size(), a, output);
            return output;
        }
    }

    @Test
    public void testPermute() {
        Solution solution = new Solution();
        int[] input = new int[]{1,2,3};
        List<List<Integer>> output = solution.permute(input);
        for(List<Integer> o : output) {
            log.info(Arrays.deepToString(o.toArray()));
        }

    }
}
