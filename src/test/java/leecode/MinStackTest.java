package leecode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinStackTest {
    class MinStack {

        private final Stack<int[]> stack;

        public MinStack() {
            this.stack = new Stack();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(new int[]{x, x});
                return;
            }
            int currentMin = stack.peek()[1];
            stack.push(new int[]{x, Math.min(x, currentMin)});
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0];
        }

        public int getMin() {
            return stack.peek()[1];
        }
    }

    @Test
    void testMinStack(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int actual = minStack.getMin();
        assertEquals(-3, actual);
        minStack.pop();
        actual = minStack.top();
        assertEquals(0, actual);
        actual = minStack.getMin();
        assertEquals(-2, actual);
    }

}
