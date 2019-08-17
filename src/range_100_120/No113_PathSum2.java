package range_100_120;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归，二叉树
 */
public class No113_PathSum2
{

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        pathSum(result, new Stack<Integer>(), root, sum);
        return result;
    }

    private void pathSum(List<List<Integer>> result, Stack<Integer> stack, TreeNode root, int sum){
        if (root.left == null && root.right == null && sum == root.val){
            stack.push(root.val);
            result.add(new ArrayList<>(stack));
            stack.pop();
            return;
        }

        sum -= root.val;
        stack.push(root.val);
        if (root.left != null){
            pathSum(result, stack, root.left, sum);
        }

        if(root.right != null){
            pathSum(result, stack, root.right, sum);
        }

        stack.pop();
    }
}
