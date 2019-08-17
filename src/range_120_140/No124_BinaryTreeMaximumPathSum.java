package range_120_140;

/**
 * 二叉树,递归
 */
public class No124_BinaryTreeMaximumPathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }

        int max = root.val + maxSum(root.left) + maxSum(root.right);
        if (root.left != null){
            max = Math.max(maxPathSum(root.left), max);
        }

        if (root.right != null){
            max = Math.max(maxPathSum(root.right), max);
        }

        return max;
    }

    public int maxSum(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftMaxSum = maxSum(root.left) + root.val;
        int rightMaxSum = maxSum(root.right) + root.val;
        int max = Math.max(Math.max(leftMaxSum, rightMaxSum), root.val);
        if (max < 0){
            return 0;
        }

        return max;
    }
}
