package range_1_20;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class No2_AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode pre = p1;
		int temp = 0;
		while(p1!=null && p2!=null){
			int total = p1.val + p2.val +temp;
			p1.val = total%10;
			temp = total/10;
			pre = p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		if(temp == 1){
			if(p1!=null){
				while(p1 != null){
					int total = temp + p1.val;
					if(total<10){
						p1.val = total;
						break;
					}
					else{
						p1.val = total%10;
						temp = total/10;
						if(p1.next == null){
							ListNode node = new ListNode(1);
							p1.next = node;
							break;
						}
						p1 = p1.next;
						
					}
				}
			}
			if(p2!=null){
				pre.next = p2;
				while(p2 != null){
					int total = temp + p2.val;
					if(total<10){
						p2.val = total;
						break;
					}
					else{
						p2.val = total%10;
						temp = total/10;
						if(p2.next == null){
							ListNode node = new ListNode(1);
							p2.next = node;
							break;
						}
						p2 = p2.next;
						
					}
				}
				
			}
			if(p1==null&&p2==null){
				ListNode node = new ListNode(1);
				pre.next = node;
			}
			return l1;
		}
		
		if(p2!=null){
			pre.next = p2;
		}
		
		if(l1 == null)
			return l2;
        return l1;
    }
	
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2){
		ListNode pre = new ListNode(0);
		ListNode head = pre;
		int carry = 0;
		while(l1!=null || l2!=null || carry!=0){
			ListNode cur = new ListNode(0);
			int total = (l1==null ? 0 : l1.val) + (l2==null ? 0 : l2.val) + carry;
			cur.val = total%10;
			carry = total/10;
			pre.next = cur;
			pre = cur;
			l1 = (l1==null ? l1 : l1.next);
			l2 = (l2==null ? l2 : l2.next);
		}
		return head.next;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		ListNode temp = addTwoNumbers(l1, l2);
		while(temp != null){
			System.out.print(temp.val +" ");
		}
	}
}
