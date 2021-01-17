 public class JumpGame {
    public boolean canJump(int[] nums) {
        // for each index, get the max distance it can reach
        // update the max distance, compare it with nums.length - 1
        // if it exceeds the nums.length-1, return true, otherwise return false
        int dis = 0;
        int n = nums.length - 1;


        for (int i = 0; i <= dis; i++) {
            // here we use index to compare, so we use i + nums[i] instead of nums[i]
            dis = Math.max(dis, i + nums[i]);
            if (dis >= n) {
                return true;
            }
        }
        return false;
    }
}