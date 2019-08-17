package range_80_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树
 */
public class No99_RecoverBinarySearchTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public void recoverTree(TreeNode root) {
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> orderList = new ArrayList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
           while (current != null){
               stack.push(current);
               current = current.left;
           }

           TreeNode node = stack.pop();
           orderList.add(node);
           current = node.right;
        }

        TreeNode node1 = null;
        TreeNode node2 = null;
        for (int i = 0; i < orderList.size(); i++){
            if (i < orderList.size() - 1 && node1 == null){
                if (orderList.get(i).val > orderList.get(i+1).val){
                    node1 = orderList.get(i);
                }
            }

            if (node1 != null){
                if (i == orderList.size() - 1 || node1.val < orderList.get(i+1).val){
                    node2 = orderList.get(i);
                    break;
                }
            }
        }

        if (node1 != null && node2 != null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }

    public void recoverTree2(TreeNode root) {
        if (root == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node1 = null;
        TreeNode node2 = null;
        TreeNode pre = null;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }

            TreeNode node = stack.pop();
            if (pre != null && node1 == null && pre.val > node.val){
                node1 = pre;
            }

            if (node1 != null && (node.val > node1.val || node.right == null && stack.isEmpty())){
                if (node.val > node1.val ){
                    node2 = pre;
                } else {
                    node2 = node;
                }

                break;
            }

            pre = node;
            current = node.right;
        }

        if (node1 != null && node2 != null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        new No99_RecoverBinarySearchTree().recoverTree2(root);
    }
}
