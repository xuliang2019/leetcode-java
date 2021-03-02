/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return recursion(root, null, null);
    }

    private boolean recursion(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        // left subtree has the max value that less than current root.val
        // right subtree has the min value that larger than current root.val
        if ((high != null && root.val >= high) || (low != null && root.val <= low)) {
            return false;
        }
        return recursion(root.left, low, root.val) && recursion(root.right, root.val, high);
    }
}