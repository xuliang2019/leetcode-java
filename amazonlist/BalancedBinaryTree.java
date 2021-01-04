public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // condition: the absolute value of left height
        // and right height less than or equals to 1.
        Boolean[] res = new Boolean[]{true};
        findHeight(root, res);
        return res[0];
    }

    public int findHeight(TreeNode root, Boolean[] res) {
        // we can end the recursion in advance if !res[0] 
        if (root == null || !res[0]) {return 0;}
        int left = findHeight(root.left, res);
        int right = findHeight(root.right, res);
        if (Math.abs(left - right) > 1) {
            res[0] = false;
        }
        // for each current root node,
        // return the longest path
        return Math.max(left, right) + 1; // +1 because we return the height to the previous node
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