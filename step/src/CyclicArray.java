import java.util.Arrays;

public class CyclicArray {
    public static boolean cyclicArray(int[] nums) {
        int size = nums.length;
        int max = size;
        int[] oldNums = nums;
        int[] ansArray = new int[size];
        int[] ansArray2 = new int[size];

        for (int i = 0; i < size; i++) {
            ansArray[i] = i + 1;
            ansArray2[i] = max;
            max--;
        }

        for (int i = 0; i < size; i++) {
            // rotate array
            reverse(nums, 0, size - 1);
            reverse(nums, 0, i - 1);
            reverse(nums, i, size - 1);
            if (Arrays.equals(ansArray, nums) || Arrays.equals(ansArray2, nums)) {
                return true;
            }
            // reset nums
            nums = oldNums;
        }
        return false;
    }

    public static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 1, 4, 2};
        int[] test2 = new int[] {1, 2, 3, 4};
        System.out.println(cyclicArray(test));
        System.out.println(cyclicArray(test2));
    }
}
