package range_100_120;

/**
 * 二叉树,递归
 */
public class No110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        if(root == null)
            return true;
        int lDepth = getDepth(root.left);
        int rDepth = getDepth(root.right);
        if(Math.abs(lDepth-rDepth) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root){
        if(root == null)
            return 0;
        int lDepth = 1;
        int rDepth = 1;
        lDepth += getDepth(root.left);
        rDepth += getDepth(root.right);
        if(lDepth > rDepth)
            return lDepth;
        else
            return rDepth;
    }
}
