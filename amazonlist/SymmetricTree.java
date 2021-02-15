public class SymmetricTree {
    // use recursion, consider two cases: 1) has children; 2) no children
    // case 1: judge by left.left.val == right.right.val && left.right.val == right.left.val
    // case 2: left == right
    public boolean isSymmetric(TreeNode root) {
        if (root == null) { return true; }
        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode left, TreeNode right) {
        // for bottom line
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}