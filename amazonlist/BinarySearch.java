public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target > nums[mid]) {
                // right half
                left = mid + 1;
            }
            else if (target < nums[mid]) {
                // left half
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
