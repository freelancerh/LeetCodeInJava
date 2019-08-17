package range_80_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树，递归
 */
public class No95_UniqueBinarySearchTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n < 1){
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start > end){
            result.add(null);
            return result;
        }

        if (start == end){
            result.add(new TreeNode(start));
            return result;
        }

        for (int i = start; i < end + 1; i++){
            List<TreeNode> leftList = generateTrees(start, i - 1);
            List<TreeNode> rightList = generateTrees(i + 1, end);
            for (TreeNode left : leftList){
                for (TreeNode right : rightList){
                    TreeNode head = new TreeNode(i);
                    head.left = left;
                    head.right = right;
                    result.add(head);
                }
            }
        }

        return result;
    }
}
