package range_20_40;

/**
 * 指针，链表
 */
public class No25_ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || k<2){
			return head;
		}
        boolean firstFlag = true;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode pre = null;
        ListNode temp = null;
        while(true){
        	int count = 0;
        	while(p2!=null && count<k){
        		p2 = p2.next;
        		count++;
        	}
        	if(count < k){
        		return head;
        	}
        	else{
        		ListNode tempHead = p1;
        		temp = p1.next;
        		while(--count > 0){
        			p1.next = temp.next;
        			temp.next = tempHead;
        			tempHead = temp;
        			temp = p1.next;
        		}
        		if(firstFlag){
        			head = tempHead;
        			firstFlag = false;
        		}
        		else{
        			pre.next = tempHead;
        		}
        		pre = p1;
        		p1 = p1.next;
        		
        	}
        }
    }
}
