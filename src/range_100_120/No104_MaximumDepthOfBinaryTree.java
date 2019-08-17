package range_100_120;

/**
 * 二叉树,递归
 */
public class No104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left==null && root.right==null)
            return 1;
        int depthl = 1;
        int depthr = 1;
        int depth = 0;
        depthl += maxDepth(root.left);
        depthr += maxDepth(root.right);
        if(depthl>depthr)
            depth = depthl;
        else
            depth = depthr;
        return depth;
    }
}
