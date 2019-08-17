package range_1_20;

/**
 * 指针，链表
 */
public class No19_RemoveNthNodeFromEndOfList {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i=0; i<n; i++)
            first = first.next;
        if(first == null)
            return head.next;
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
    
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
