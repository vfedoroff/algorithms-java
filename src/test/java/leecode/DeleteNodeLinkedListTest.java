package leecode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DeleteNodeLinkedListTest {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode append(int val) {
            this.next = new ListNode(val);
            return this.next;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int[] toArray() {
            ArrayList<Integer> out = new ArrayList();
            ListNode head = this;
            while (head != null) {
                out.add(head.val);
                head = head.next;
            }
            return out.stream().mapToInt(x->x).toArray();
        }
    }

    class Solution {
        public void deleteNode(ListNode node) {
            if(node.next==null || node==null )
                return ;
            node.val = node.next.val;
            //delete next node
            node.next = node.next.next;
        }
    }

    @Test
    void testDeleteNode(){
        // 4,5,1,9
        ListNode head = new ListNode(4);
        // Delete node with val == 1
        ListNode node = head.append(5).append(1);
        node.append(9);
        Solution solution = new Solution();
        int[] expected = new int[]{4,5,9};
        solution.deleteNode(node);
        assertArrayEquals(expected, head.toArray());
        // head = [0,1], node = 0
        head = new ListNode(0, new ListNode(1));
        solution.deleteNode(head);
        expected = new int[]{1};
        assertArrayEquals(expected, head.toArray());
    }
}
