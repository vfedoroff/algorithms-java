package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MiddleOfLinkedListTest {

    class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        System.out.printf("slow: %s fast: %s\n", slow != null ? slow.value : -1 , fast != null ? fast.value: -1);
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            System.out.printf("slow: %s fast: %s\n", slow != null ? slow.value : -1 , fast != null ? fast.value: -1);
        }
        return slow;
    }

    @Test
    void testFindMiddle(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Assertions.assertEquals(3,findMiddle(head).value);

        head.next.next.next.next.next = new ListNode(6);
        Assertions.assertEquals(4,findMiddle(head).value);
        head.next.next.next.next.next.next = new ListNode(7);
        Assertions.assertEquals(4,findMiddle(head).value);
    }

}
