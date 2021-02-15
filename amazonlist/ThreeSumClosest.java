import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // sort array and use three pointers
        int res = nums[0] + nums[1] + nums[2]; // initialize res
        Arrays.sort(nums);

        for (int start = 0; start < nums.length-2; start++) {
            int middle = start + 1;
            int end = nums.length - 1;

            // find the closest sum between middle and end range
            while (middle < end) {
                int sum = nums[start] + nums[middle] + nums[end];
                // if sum > target, scan middle side
                // if sum < target, scan end side
                // else return sum
                if (sum > target) {
                    end--;
                }
                else if (sum < target) {
                    middle++;
                }
                else {
                    return sum;
                }
                // get the closer one by comparing abs(res-target) and abs(sum-target)
                if (Math.abs(res - target) > Math.abs(sum - target)) {
                    res = sum;
                }
            }

        }
        return res;
    }
}