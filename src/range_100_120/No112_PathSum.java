package range_100_120;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

/**
 * 递归，二叉树
 */
public class No112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;
        if (root == null) {
            return result;
        }
        if ((sum -= root.val) == 0 && root.left == null && root.right == null)
            result = true;
        if (root.left != null) {
            result = hasPathSum(root.left, sum);
        }
        if (result == true)
            return result;
        if (root.right != null) {
            result = hasPathSum(root.right, sum);
        }
        return result;

    }
}