package range_100_120;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表,二叉查找树
 */
public class No109_ConvertSortedListToBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }

        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        return sortedListToBST(list);
    }

    private TreeNode sortedListToBST(List<Integer> list) {
        if (list == null || list.size() == 0){
            return null;
        }

        int middleIndex = list.size() / 2;
        TreeNode node = new TreeNode(list.get(middleIndex));
        node.left = sortedListToBST(list.subList(0, middleIndex));
        node.right = sortedListToBST(list.subList(middleIndex + 1, list.size()));
        return node;
    }
}
