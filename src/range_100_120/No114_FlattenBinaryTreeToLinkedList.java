package range_100_120;

/**
 * 二叉树，递归
 */
public class No114_FlattenBinaryTreeToLinkedList {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }

        flatten(root.left);
        flatten(root.right);
        if (root.left != null){
            TreeNode pointer = root.left;
            while (pointer.right != null){
                pointer = pointer.right;
            }

            pointer.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}
