package leecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder();
            int carry = 0;
            int pos1 = num1.length() - 1;
            int pos2 = num2.length() - 1;
            while ( pos1 >= 0 || pos2 >= 0){
                int x1 = pos1 >= 0 ? num1.charAt(pos1) - '0' : 0;
                int x2 = pos2 >= 0 ? num2.charAt(pos2) - '0' : 0;
                int value = (x1 + x2 + carry) % 10;
                carry = (x1 + x2 + carry) / 10;
                res.append(value);
                pos1--;
                pos2--;
            }
            if (carry != 0)
                res.append(carry);
            return res.reverse().toString();
        }
    }

    @Test
    void testAddStrings(){
        Solution solution = new Solution();
        String actual = solution.addStrings("1", "19");
        assertEquals("20", actual);
    }
}
