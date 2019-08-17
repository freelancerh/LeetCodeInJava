package range_80_100;

/**
 * 链表,指针
 */
public class No83_RemoveDuplicatesFromSortedList {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode now = head;
        while(now!=null){
            while(now.next!=null && now.val==now.next.val)
                now.next = now.next.next;
            now = now.next;
        }
        return head;
    }
}
