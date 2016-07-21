package TwentyToFourty;

public class TwentyFour_SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        ListNode pointer = head;
        ListNode pre = head;
        ListNode pointera = null;
        ListNode pointerb = null;
        int count = 1;
        while(pointer != null){
        	if(count%2 == 1){
        		pointera = pointer;
        	}
        	else{
        		pointerb = pointer;
        		pointera.next = pointerb.next;
        		pointerb.next = pointera;
        		if(count != 2){
        			pre.next = pointerb;
        		}
        		else{
        			head = pointerb;
        		}
        		pre = pointera;
        		pointer = pre;
        	}
        	count++;
        	pointer = pointer.next;
        }
        return head;
    }
	
	public static void main(String[] args){
		ListNode list = new ListNode(0);
		ListNode pointer = list;
		for(int i=1; i<4; i++){
			pointer.next = new ListNode(i);
			pointer = pointer.next;
		}
		pointer = new TwentyFour_SwapNodesInPairs().swapPairs(list);
		while(pointer != null){
			System.out.println(pointer.val);
			pointer = pointer.next;
		}
	}
}
