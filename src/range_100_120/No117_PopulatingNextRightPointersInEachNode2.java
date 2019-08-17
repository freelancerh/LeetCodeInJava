package range_100_120;

/**
 * 二叉树,递归,找规律
 */
public class No117_PopulatingNextRightPointersInEachNode2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null){
            return null;
        }

        if (root.left != null && root.right != null){
            root.left.next = root.right;
        }

        Node left = root.right != null ? root.right : root.left;
        Node next = root.next;
        while (next != null && next.left == null && next.right == null) {
            next = next.next;
        }

        Node right = null;
        if (next != null){
            right = next.left != null ? next.left : next.right;
        }

        if(left != null && right != null){
            left.next = right;
        }

        connect(root.right);
        connect(root.left);
        return root;
    }
}
