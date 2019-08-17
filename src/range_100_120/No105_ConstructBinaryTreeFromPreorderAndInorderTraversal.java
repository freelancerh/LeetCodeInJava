package range_100_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二叉树
 */
public class No105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(Arrays.stream(preorder).boxed().collect(Collectors.toList()), Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (inorder == null || preorder == null){
            return null;
        }

        if (inorder.size() == 0 && preorder.size() == 0){
            return null;
        }

        if (inorder.size() == 1){
            return new TreeNode(inorder.get(0));
        }

        int value = preorder.get(0);
        int breakIndex = inorder.indexOf(value);

        TreeNode node = new TreeNode(value);
        node.left = buildTree(preorder.subList(1, breakIndex+1), inorder.subList(0, breakIndex));
        node.right = buildTree(preorder.subList(breakIndex + 1, preorder.size()), inorder.subList(breakIndex + 1, inorder.size()));
        return node;
    }

    public static void main(String[] args) {
        new No105_ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

}
