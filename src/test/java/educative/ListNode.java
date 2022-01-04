package educative;

import java.util.ArrayList;

public class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    ListNode add(ListNode next) {
        this.next = next;
        return this.next;
    }

    int[] toArray(){
        ListNode head = this;
        ArrayList<Integer> list = new ArrayList();
        list.add(this.value);
        while (head.next != null) {
            list.add(head.next.value);
            head = head.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
