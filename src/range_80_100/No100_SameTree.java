package range_80_100;

/**
 * 二叉树,递归
 */
public class No100_SameTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null)
            return true;
        if(root2==null ||root1==null)
            return false;
        if(root1.val != root2.val)
            return false;
        return isSameTree(root1.left, root2.left)&&isSameTree(root1.right, root2.right);
    }
}
