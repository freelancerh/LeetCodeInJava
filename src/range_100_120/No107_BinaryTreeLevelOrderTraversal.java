package range_100_120;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树,队列
 */
public class No107_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> tmp = new ArrayList();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode tmpNode = q.poll();
                tmp.add(tmpNode.val);
                if(tmpNode.left != null){
                    q.add(tmpNode.left);
                }
                if(tmpNode.right != null){
                    q.add(tmpNode.right);
                }
            }
            list.add(0,tmp);
        }
        return list;
    }
}
