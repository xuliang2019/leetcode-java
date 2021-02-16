public class JumpGame2 {
    public int jump(int[] nums) {
        int step = 0;
        int currMax = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            // calculate steps every time after reached the current max distance
            if (i > currMax) {
                // step becomes 1 when i = 1 and currMax = 0
                // this case shows that we jumped the first step from index 0
                step++;
                // update currMAX to the most recent max
                currMax = max;
            }
            // get max distance at current index
            max = Math.max(max, i + nums[i]);
        }
        return step;
    }
}
