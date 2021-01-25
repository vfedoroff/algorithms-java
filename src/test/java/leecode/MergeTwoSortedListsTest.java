package leecode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeTwoSortedListsTest {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
          Integer[] ToArray() {
              ArrayList<Integer> result = new ArrayList<>();
              ListNode node = this;
              while (node != null) {
                  result.add(node.val);
                  node = node.next;
              }
              return result.stream().toArray(Integer[]::new);
          }
      }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(-1);
            ListNode prev = head;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                prev = prev.next;
            }
            prev.next = l1 == null ? l2 : l1;
            return head.next;
        }
    }

    @Test
    void testMergeTwoLists() {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Solution solution = new Solution();
        ListNode actual = solution.mergeTwoLists(l1, l2);
        assertArrayEquals(new Integer[]{1, 1, 2, 3, 4, 4}, actual.ToArray());
    }
}
