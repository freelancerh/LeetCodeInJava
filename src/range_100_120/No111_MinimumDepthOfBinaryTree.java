package range_100_120;

/**
 * 二叉树,递归
 */
public class No111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null)
            return 1;
        int depthl = 1;
        int depthr = 1;
        int depth = 0;
        if(root.left != null)
            depthl += minDepth(root.left);
        if(root.right != null)
            depthr += minDepth(root.right);
        if(root.left==null || root.left!=null&&root.right!=null&&depthl>depthr)
            depth = depthr;
        else if(root.right==null || root.right!=null&&root.left!=null&&depthr>=depthl)
            depth = depthl;
        return depth;
    }
}
