 public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int maxSum = nums[0];
//         int currSum = nums[0];
//         int start = 0, end = 0;
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > currSum + nums[i]) {
//                 currSum = nums[i];
//                 start = i;
//             }
//             else {
//                 currSum += nums[i];
//             }
//
//             if (maxSum < currSum) {
//                 maxSum = currSum;
//                 end = i;
//             }
//         }
//         return maxSum;
//     }
// }