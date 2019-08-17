package range_20_40;


/**
 * 链表，指针
 */
public class No21_MergeTwoSortedLists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode newNode = new ListNode(0);
        ListNode list = null;
        boolean flag = true;
        while (l1 != null && l2 != null) {
            ListNode tmp = null;
            if (l1.val < l2.val) {
                tmp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp = new ListNode(l2.val);
                l2 = l2.next;
            }
            newNode.next = tmp;
            if (flag) {
                list = newNode.next;
                flag = false;
            }
            newNode = newNode.next;
        }
        if (l1 != null) {
            newNode.next = l1;
        }
        if (l2 != null) {
            newNode.next = l2;
        }
        return list;

    }
}