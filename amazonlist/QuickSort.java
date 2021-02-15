import java.util.Arrays;

public class QuickSort {

    public static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            swap(array, left, (left + right) / 2);
            int i = left;
            int j = right;
            int pivot = array[i];
            while (i < j) {
                while (i < j && array[j] >= pivot) {
                    j--;
                }
                if (i < j) {
                    array[i++] = array[j];
                }
                while (i < j && array[i] < pivot) {
                    i++;
                }
                if (i < j) {
                    array[j--] = array[i];
                }

            }
            array[i] = pivot;
            quickSort(array, left, i - 1); // sort pivot left part
            quickSort(array, i + 1, right); // sort pivot right part
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7, 8, 9, 5, 3};
        quickSort(nums, 0, 4);
        System.out.println(Arrays.toString(nums));

    }

}
