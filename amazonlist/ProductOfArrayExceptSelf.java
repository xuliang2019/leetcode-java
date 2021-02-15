 public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        // two loops: front and back
        // for the front loop, overwrite nums[i] with the prodcut that befor it
        // for the back loop, overwrite nums[i] with nums[i] * product after it
        int[] res = new int[nums.length];
        int left = 1;
        int right = 1;
        // after this loop, we get the correct prodcut for the last element
        for (int i = 0; i < nums.length; i++) {
            res[i] = left;
            left *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}