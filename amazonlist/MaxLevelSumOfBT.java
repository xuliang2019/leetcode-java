import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumOfBT {
    public int maxLevelSum(TreeNode root) {
        // check input
        if (root == null) {return 1;}

        // use BFS, calculate each level sum
        // find the maxSum and mark current level
        int maxSum = Integer.MIN_VALUE;
        int level = 1;
        int maxLevel = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // get the num of nodes at current level
            int count = queue.size();
            int sum = 0;

            while (count > 0) {
                TreeNode node = queue.poll();
                // calculate the sum of current level
                sum += node.val;

                // collect next level nodes
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                count--;
            }

            // get maxSum
            if (maxSum < sum) {
                maxSum = sum;
                maxLevel = level;
            }
            // update level
            level++;
        }
        return maxLevel;
    }

}