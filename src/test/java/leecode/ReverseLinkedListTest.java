package leecode;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLinkedListTest {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode append(int val){
            this.next = new ListNode(val);
            return this.next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode head = this;
            while (head != null)
            {
                sb.append(head.val);
                sb.append("->");
                head = head.next;
            }
            return sb.toString();
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head  == null) {
                return null;
            }
            Stack<ListNode> stack = new Stack<>();
            ListNode ptr = head;
            while (ptr.next != null)
            {
                stack.push(ptr);
                ptr = ptr.next;
            }
            head = ptr;
            while (!stack.isEmpty())
            {
                ptr.next = stack.peek();
                ptr = ptr.next;
                stack.pop();
            }
            ptr.next = null;
            return head;
        }
    }

    @Test
    void testReverseList(){
        ListNode head = new ListNode(1);
        ListNode tail = head.append(2);
        tail = tail.append(3);
        tail = tail.append(4);
        tail.append(5);
        Solution solution = new Solution();
        ListNode actual = solution.reverseList(head);
        assertEquals("5->4->3->2->1->", actual.toString());
    }
}
