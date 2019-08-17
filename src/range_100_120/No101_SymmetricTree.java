package range_100_120;

/**
 * 二叉树,递归
 */
public class No101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        TreeNode mirror = mirror(root.left);
        return chargeSymmetric(mirror, root.right);
    }

    public boolean chargeSymmetric(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null)
            return true;
        if(root1!=null&&root2==null ||root1==null&&root2!=null)
            return false;
        if(root1.val != root2.val)
            return false;
        return chargeSymmetric(root1.left, root2.left)&&chargeSymmetric(root1.right, root2.right);
    }

    public TreeNode mirror(TreeNode root){
        if(root == null)
            return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
        return root;
    }
}
