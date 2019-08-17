package range_80_100;

/**
 * 链表
 */
public class No82_RemoveDuplicatesFromSortedList2 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        head = getValidNode(head);
        if (head == null) {
            return null;
        }

        ListNode pointer = head.next;
        ListNode next = head;
        while (pointer != null) {
            ListNode validPointer = getValidNode(pointer);
            next.next = validPointer;
            next = next.next;
            if (validPointer == null) {
                break;
            }

            pointer = validPointer.next;
        }

        return head;
    }

    private ListNode getValidNode(ListNode node) {
        while (node != null) {
            if (node.next == null || node.val != node.next.val) {
                return node;
            }

            ListNode pre = node;
            node = pre.next;
            while (node != null && node.val == pre.val) {
                pre = node;
                node = node.next;
            }
        }

        return null;
    }
}
