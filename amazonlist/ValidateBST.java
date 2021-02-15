public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return recursion(root, null, null);
    }

    private boolean recursion(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        // for left subtree, it has max value which is current node.val
        // for right subtree, it has min value which is current node.val
        if ((high != null && root.val >= high) || (low != null && root.val <= low)) {
            return false;
        }
        return recursion(root.left, low, root.val) && recursion(root.right, root.val, high);
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
