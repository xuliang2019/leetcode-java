import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{7, 9, 8, 5, 3};
        System.out.println(findKthSmallest(nums, 2));
    }

    public  static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int findKthSmallest(int[] nums, int k) {
        // check input
        if (nums.length == 0 || nums == null) {
            return Integer.MIN_VALUE;
        }
        return quickSelect(nums, k, 0, nums.length - 1);
    }

    public static int quickSelect(int[] nums, int k, int start, int end) {
        // select random pivot
        Random random = new Random();
        int index = start + random.nextInt(end - start + 1);
        int pivot = nums[index];
        // swap the pivot to the end of nums
        swap(nums, index, end);

        // scan nums, put the values that larger than pivot to nums right side
        int left = start;
        int right = end;
        while (left < right) {
            if (nums[left] >= pivot) {
                swap(nums, left, right);
                left--; // since the value is changed, we need to go back and check the nums[left]
                right--;
            }
            left++;
        }
        // make the left pointer points to the first number that larger or equals to pivot
        swap(nums, left, end);

        int m = left - start;
        // determine which side to go
        if (k - 1 == m) {
            return pivot;
        }
        // left side
        else if (k - 1 < m) {
            return quickSelect(nums, k, start, left - 1);
        }
        // right side
        else {
            return quickSelect(nums, k - m, left, end);
        }
    }
}
