package binarytree;

/**
 * 116
 */
public class Connect {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        traverse(left.left, left.right);
        traverse(right.left, right.right);
        traverse(left.right, right.left);
    }

    public static void main(String[] args) {
        // root = [1,2,3,4,5,6,7]
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node3 = new Node(3, node6, node7, null);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node2 = new Node(2, node4, node5, null);
        Node node1 = new Node(1, node2, node3, null);
        Connect connect = new Connect();
        connect.connect(node1);


    }
}
