package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {
    public static ListNode reverse(ListNode head) {
        ListNode current = head; // current node that we will be processing
        ListNode previous = null; // previous node that we have processed
        ListNode next = null; // will be used to temporarily store the next node
        while (current != null) {
            next = current.next;
            current.next = previous; // reverse the current node
            previous = current; // before we move to the next node, point previous to the current node
            current = next; // move on the next node
        }
        return previous;
    }

    @Test
    void testReverse(){
        ListNode head = new ListNode(2);
        head.add(new ListNode(4))
                .add(new ListNode(6))
                .add(new ListNode(8))
                .add(new ListNode(10));
        ListNode actual = reverse(head);
        Assertions.assertEquals(10, actual.value);
    }
}
