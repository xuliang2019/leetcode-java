import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOperations {
    /*
        three types of operations
        [0, x] add the x value to all the elements in the nums array
        [1, x] append the x value to the end of the nums array
        [2] get the min value of nums array

        output: append the outcome of [2] operations, i.e all the min value when called [2] operation
     */
    public static int[] arrayOperations(int[] nums, int[][] operations) {
        int m = operations.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] action = operations[i];
            if (action[0] == 0) {
                addValue(nums, action[1]);
            }
            else if (action[0] == 1) {
                nums = appendVal(nums, action[1]);
            }
            else {
                int min = getMin(nums);
                list.add(min);
            }
        }

        int size = list.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int getMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public static void addValue(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            nums[i] += val;
        }
    }

    public static int[] appendVal(int[] nums, int val) {
        int size = nums.length;
        int[] newNums = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            if (i == size) {
                newNums[i] = val;
            }
            else {
                newNums[i] = nums[i];
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[][] operations = new int[][]{{0, 1}, {1, 2}, {2}};
        int[] res = arrayOperations(nums, operations);
        System.out.println(Arrays.toString(res));
    }
}
