 public class BinaryTreeMaxPathSum {
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathDown(root);
        return max;
    }

    public int maxPathDown(TreeNode root) {
        if (root == null) {return 0;}
        // get the left max
        int left = maxPathDown(root.left);
        // get the right max
        int right = maxPathDown(root.right);
        // in case of negative values
        int curr = Math.max(root.val, Math.max(left + root.val, right + root.val));
        // update max
        max = Math.max(max, Math.max(curr, left + right + root.val));
        // return the larger branch + current node.val
        return curr;
    }
}

// class Solution {
//     int max;
//     public int maxPathSum(TreeNode root) {
//         max = Integer.MIN_VALUE;
//         maxPathDown(root);
//         return max;
//     }
//
//     public int maxPathDown(TreeNode root) {
//         if (root == null) { return 0; }
//         // get the left max
//         int left = Math.max(0, maxPathDown(root.left));
//         // get the right max
//         int right = Math.max(0, maxPathDown(root.right));
//         max = Math.max(max, left + right + root.val);
//         // return the larger branch + current node.val
//         return Math.max(left, right) + root.val;
//     }
// }

// you can imagine the helper( ) function goes from the bottom of the tree to the top, it's in post-order manner.
// At every node, we need to make a decision, if the sum comes from the left path larger than the right path,
// we pick the left path and plus the current node's value, this recursion goes all the way up to the root node.