package range_100_120;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二叉树,数组,递归
 */
public class No108_ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return sortedArrayToBST(numList);
    }

    public TreeNode sortedArrayToBST(List<Integer> numList) {
        if (numList == null || numList.size() == 0) {
            return null;
        }

        int middleIndex = numList.size() / 2;
        int value = numList.get(middleIndex);
        TreeNode node = new TreeNode(value);
        node.left = sortedArrayToBST(numList.subList(0, middleIndex));
        node.right = sortedArrayToBST(numList.subList(middleIndex + 1, numList.size()));
        return node;
    }
}