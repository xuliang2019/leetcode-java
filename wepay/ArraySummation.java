// two sum + hashSet

class Solution {
    public int[] arraySummation(int[] nums, int[] tests) {
        Set<Integer> set = new HashSet<>();
        for (int t = 0; t < tests.length; t++) {
            int target = tests[t];
            for (int i = 0; i < nums.length; i++) {
                int remain = target - nums[i];
                if (set.contains(remain)) {
                    return true;
                }
                set.add(nums[i]);
            }
        }

        return false;
    }
}