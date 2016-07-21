package TwentyToFourty;

import java.util.Comparator;
import java.util.PriorityQueue;



public class TwentyThree_MergeKSortedLists {
	public ListNode mergeKLists1(ListNode[] lists){
		if(lists==null || lists.length==0){
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			public int compare(ListNode a, ListNode b){
				if(a.val < b.val){
					return -1;
				}
				else if(a.val == b.val){
					return 0;
				}
				else{
					return 1;
				}
			}
		});
		for(int i=0; i<lists.length; i++){
			if(lists[i] != null)
				queue.add(lists[i]);
		}
		ListNode head = new ListNode(0);
		ListNode tail = head;
		while(!queue.isEmpty()){
			tail.next = queue.poll();
			tail = tail.next;
			if(tail.next != null){
				queue.add(tail.next);
			}
		}
		return head.next;
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0)
			return null;
		else if(lists.length == 1){
			return lists[0];
		}
        for(int i=0; i<lists.length-1; i++){
        	lists[i+1] = mergeTwoLists(lists[i], lists[i+1]);
        }
        return lists[lists.length-1];
    }
	
	public ListNode mergeTwoLists(ListNode a, ListNode b){
		if(b == null)
			return a;
		else if(a == null)
			return b;
		ListNode pointera = a;
		ListNode pointerb = b;
		ListNode pointer = b;
		boolean flag = true;
		while(pointera!=null || pointerb!=null){
			if(pointera!=null && pointerb!=null){
				if(pointera.val < pointerb.val){
					if(flag){
						pointer = pointera;
						pointera = pointera.next;
						pointer.next = pointerb;
						b = pointer;
						flag = !flag;
					}
					else{
						b.next = pointera;
						pointera = pointera.next;
						b = b.next;
						b.next = pointerb;
					}
				}
				else{
					b = pointerb;
					pointerb = pointerb.next;
					
				}
			}
			else if(pointerb == null){
				b.next = pointera;
				break;
			}
			else{
				break;
			}
		}
		return pointer;
	}
	
	public static void main(String[] args){
		ListNode[] lists = new ListNode[2];
		/*for(int i=0; i<2; i++){
			lists[i] = new ListNode(3+i);
			lists[i].next = new ListNode(4+i);
			lists[i].next.next = new ListNode(6+i);
			lists[i] = new ListNode(i);
		}*/
		lists[0] = new ListNode(1);
		lists[1] = new ListNode(0);
		ListNode pointer =new TwentyThree_MergeKSortedLists().mergeKLists(lists);
		while(pointer != null){
			System.out.println(pointer.val);
			pointer = pointer.next;
		}
	}
	
}
