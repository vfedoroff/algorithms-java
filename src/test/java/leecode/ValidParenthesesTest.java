package leecode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> brackets = new HashMap<>(){{
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }};
            Deque<Character> stack = new ArrayDeque<>();
            int length = s.length();
            for(int i=0; i < length; i++) {
                Character c = s.charAt(i); // boxing
                if (! brackets.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character top = stack.pop();
                    if (! brackets.get(c).equals(top)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    @Test
    void testIsValid(){
        Solution solution = new Solution();
        boolean actual = solution.isValid("()");
        assertTrue(actual);
        actual = solution.isValid("()[]{}");
        assertTrue(actual);
        actual = solution.isValid("(]");
        assertFalse(actual);
        actual = solution.isValid("([)]");
        assertFalse(actual);
    }
}
