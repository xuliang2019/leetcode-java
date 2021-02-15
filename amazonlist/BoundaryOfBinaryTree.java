import java.util.ArrayList;
import java.util.List;


public class BoundaryOfBinaryTree {
    // basic idea is to add left boundary node values in preorder,
    // then add the bottome line node values (leaves that neither belongs to left boundary nor right boundary)
    // finally, add the right boundary node values in postorder

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            // the root value is the first element in the res list
            res.add(root.val);
            // find the left bound and right bound recursively
            getBounds(root.left, res, true, false);
            getBounds(root.right, res, false, true);
        }
        return res;
    }

    private void getBounds(TreeNode node, List<Integer> res, Boolean lb, Boolean rb) {
        if (node == null) { return; }
        // if on left boundary, add node.value in preorder
        if (lb) { res.add(node.val); }
        // add bottom leaves
        if (!lb && !rb && node.left == null && node.right == null) {
            res.add(node.val);
        }
        // find the left and right boundary nodes recursively
        // In genral, node.left is on left boundary.
        // However, when node is on right boundary and node.right is null, then the node.left is on right boundary
        // same mechanism for node.right
        getBounds(node.left, res, lb, rb && node.right == null);
        getBounds(node.right, res, lb && node.left == null, rb);
        // if on right boundary, add node.value in postorder
        if (rb) { res.add(node.val); }
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