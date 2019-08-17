package range_100_120;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树,队列
 */
public class No103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()){
                list.add(queue.poll());
            }

            List<Integer> leftOrderList = list.stream().map(node -> node.val).collect(Collectors.toList());
            if (level % 2 == 0){
                result.add(leftOrderList);
            } else {
                Collections.reverse(leftOrderList);
                result.add(leftOrderList);
            }

            for (TreeNode node : list){
                if (node.left != null){
                    queue.offer(node.left);
                }

                if (node.right != null){
                    queue.offer(node.right);
                }
            }

            level++;
        }

        return result;
    }
}
