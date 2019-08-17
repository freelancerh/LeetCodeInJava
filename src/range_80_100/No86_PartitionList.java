package range_80_100;

/**
 * 链表
 */
public class No86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }

        ListNode pointer = head;
        ListNode insertPoint = null;
        while (pointer != null && pointer.val < x){
            insertPoint = pointer;
            pointer = pointer.next;
        }

        ListNode pre = null;
        while (pointer != null){
            while (pointer != null && pointer.val >= x){
                pre = pointer;
                pointer = pointer.next;
            }

            if (pointer == null){
                break;
            }

            if (insertPoint == null){
                pre.next = pointer.next;
                pointer.next = head;
                head = pointer;
            } else {
                pre.next = pointer.next;
                pointer.next = insertPoint.next;
                insertPoint.next = pointer;
            }

            insertPoint = pointer;
            pointer = pre;
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
