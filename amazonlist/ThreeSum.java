import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the array and use three pointers
        // when encounter equal elements, skip it and increase current index
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) { // todo not understand here
                int middle = i+1;
                int end = nums.length - 1;
                int remain = 0 - nums[i];

                // find answers between middle and end range
                while (middle < end) {
                    if (remain == nums[middle] + nums[end]) {
                        res.add(Arrays.asList(nums[i], nums[middle], nums[end]));
                        // skip equal elements
                        while (middle < end && nums[middle] == nums[middle+1]) {middle++;}
                        while (middle < end && nums[end] == nums[end-1]) {end--;}
                        // keep finding new answer
                        middle++;
                        end--;
                    }
                    else if (remain > nums[middle] + nums[end]) {
                        middle++;
                    }
                    else {
                        end--;
                    }
                }
            }
        }
        return res;
    }
}