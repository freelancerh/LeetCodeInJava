package range_100_120;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二叉树
 */
public class No106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(Arrays.stream(inorder).boxed().collect(Collectors.toList()), Arrays.stream(postorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if (inorder == null || inorder.size() == 0){
            return null;
        }

        if (postorder == null || postorder.size() == 0){
            return null;
        }

        if (inorder.size() != postorder.size()){
            return null;
        }

        if (inorder.size() == 1){
            return new TreeNode(inorder.get(0));
        }

        int value = postorder.get(postorder.size() - 1);
        int index = inorder.indexOf(value);
        TreeNode node = new TreeNode(value);
        node.left = buildTree(inorder.subList(0, index), postorder.subList(0, index));
        node.right = buildTree(inorder.subList(index + 1, inorder.size()), postorder.subList(index, postorder.size() - 1));
        return node;
    }
}
