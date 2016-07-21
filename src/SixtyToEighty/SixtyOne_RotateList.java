package SixtyToEighty;
/*
 * 该题目不难，先找到原始列表分裂的中间位置，然后进行指针的操作，即可得到，需要注意的是这里的k可能大于原始列表长度，需要对它取模*/
public class SixtyOne_RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head==null || k<1)
			return head;
        ListNode assistantNode = head;
        int len = 0;
        while(assistantNode != null){
        	len++;
        	assistantNode = assistantNode.next;
        }
        k = k%len;
        assistantNode = head;
        for(int i=k; i>0; i--){
        	if(assistantNode.next != null)
        		assistantNode = assistantNode.next;
        	else{
        		return head;
        	}
        }
        ListNode newRear = head;
        while(assistantNode.next != null){
        	newRear = newRear.next;
        	assistantNode = assistantNode.next;
        }
        assistantNode.next = head;
        head = newRear.next;
        newRear.next = null;
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
