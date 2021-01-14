import java.util.Random;

public class QuickSelect {
    public static int findKthSmallest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int len = nums.length;

        return quickSelect(nums, k, 0, len - 1);
    }

    private static int quickSelect(int[] nums, int k, int start, int end) {

        Random rand = new Random();
        int index = rand.nextInt(end - start + 1) + start;
        int pivot = nums[index];
        swap(nums, index, end);

        int left = start;
        int right = end;

        //after partition only the pivot element moves into it's correct position
        while (left < right) {
            if (nums[left] >= pivot) {
                swap(nums, left, right);
                left--; // check current nums[left] due to the swap of nums[left] and nums[right]
                right--;
            }
            left++;
        }
        //left is now pointing to the first number that is greater than or equal to the pivot
        // left is pivot index now
        swap(nums, left, end);

        //m is the number of numbers that is smaller than pivot
        int m = left - start;

        if (m == k - 1) { //in order to find the kth smallest number, there must be k - 1 number smaller than it
            return pivot;
        }
        else if (k - 1 < m) { //target is in the left subarray
            return quickSelect(nums, k, start, left-1);  //  [start, left-1], [left, end]
        }
        else {
            //target is in the right subarray, but need to update k
            //Since we have discarded m numbers smaller than it which is in the right subarray
            return quickSelect(nums, k - m, left, end);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{8, 2, 4};
        System.out.println(findKthSmallest(nums, 3));
    }
}