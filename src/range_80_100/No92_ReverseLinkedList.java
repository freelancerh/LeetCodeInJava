package range_80_100;

/**
 * 链表
 */
public class No92_ReverseLinkedList {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m > n || m == n){
            return head;
        }

        int count = n - m;
        if (m == 1){
            return reverse(head, count);
        } else {
            ListNode prePointer = head;
            while (m > 2){
                prePointer = prePointer.next;
                m--;
            }

            prePointer.next = reverse(prePointer.next, count);
            return head;
        }
    }

    private ListNode reverse(ListNode head, int count){
        ListNode pointer = head;
        while (count > 0){
            ListNode temp = pointer.next;
            pointer.next = pointer.next.next;
            temp.next = head;
            head = temp;
            count--;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
