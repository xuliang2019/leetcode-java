public class MergeSort {
    private int[]  nums;
    private int[] tempArray;


    // constructor
    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    //    public void mergeSort(int low, int high) {
//        // if there is only one element in nums array
//        if (low >= high) { return; }
//        int mid = (low + high) / 2;
//        mergeSort(low, mid);
//        mergeSort(mid+1, high);
//        merge(low, mid, high);
//
//    }
//
//    public void merge(int low, int mid, int high) {
//        // copy the values in nums to tempArray
//        for (int i = 0; i < nums.length; i++) {
//            tempArray[i] = nums[i];
//        }
//        // three pointers, one for left part array, one for  right part array, and the last for nums
//        int i = low;
//        int j = mid + 1;
//        int k = low;
//        while (i <= mid && j <= high) {
//            if (tempArray[i] <= tempArray[j]) {
//                nums[k] = tempArray[i];
//                i++;
//            }
//            else {
//                nums[k] = tempArray[j];
//                j++;
//            }
//            k++;
//        }
//        // for the rest of elements in left part array
//        while (i <= mid) {
//            nums[k] = tempArray[i];
//            i++;
//            k++;
//        }
//        // for the rest of elements in right part array
//        while (j <= high) {
//            nums[k] = tempArray[j];
//            j++;
//            k++;
//        }
//    }
    public void mergeSort(int low, int high) {
        if (low >= high) {return;}
        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }

    public void merge(int low, int mid, int high) {
        for (int i = 0; i < nums.length; i++) {
            tempArray[i] = nums[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (tempArray[i] <= tempArray[j]) {
                nums[k] = tempArray[i];
                i++;
            }
            else {
                nums[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            nums[k] = tempArray[i];
            i++;
            k++;
        }
        while (j <= high) {
            nums[k] = tempArray[j];
            j++;
            k++;
        }
    }
}