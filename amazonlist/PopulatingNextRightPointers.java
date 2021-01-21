public class PopulatingNextRightPointers {
    public Node connect(Node root) {
        Node dummyHead = new Node(0);
        Node current = dummyHead;
        Node res = root;

        while (root != null) {
            if (root.left != null) {
                current.next = root.left;
                current = current.next;
            }
            if (root.right != null) {
                current.next = root.right;
                current = current.next;
            }
            root = root.next;
            if (root == null) {
                // move root to next level
                root = dummyHead.next;
                // move current back to the begining
                current = dummyHead;
                // reset dummyHead.next to null for next level
                // for each level, dummyHead is always initialized as 0 -> null
                dummyHead.next = null;
            }
        }
        return res;

    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
