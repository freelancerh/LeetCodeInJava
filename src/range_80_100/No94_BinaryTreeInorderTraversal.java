package range_80_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树
 */
public class No94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode pointer = root;
        while (pointer != null || !stack.isEmpty()){
            while (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }

            TreeNode node = stack.pop();
            result.add(node.val);
            pointer = node.right;
        }

        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return new ArrayList<>(0);
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
