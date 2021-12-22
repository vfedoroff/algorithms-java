package educative;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LinkedListCycleTest {
    class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        ListNode add(ListNode next) {
            this.next = next;
            return next;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
                return true; // found the cycle
        }
        return false;
    }

    @Test
    void testHasCycle(){
        ListNode head = new ListNode(1);
        ListNode tail = head.add(new ListNode(2));
        tail = tail.add(new ListNode(3));
        ListNode cycle = tail;
        tail = tail.add(new ListNode(4));
        tail = tail.add(new ListNode(5));
        tail = tail.add(new ListNode(6));
        tail.add(cycle);
        Assertions.assertTrue(hasCycle(head));
    }
}
