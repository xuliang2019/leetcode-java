public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;

        if (len % 2 == 0){  //  even case
            double left = findKthHelper(nums1, 0, nums2, 0, len/2);
            double right = findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
            return (double)(left + right)/2;
        }else {  // odd case
            return findKthHelper(nums1, 0, nums2, 0, len/2 + 1);
        }
    }

    // Kth means the Kth value in the final sorted array that merged by nums1 and nums2
    private double findKthHelper(int[] A, int aStart, int[] B, int bStart, int k){
        // A array was visited completely, so the result exists in B
        if (aStart >= A.length){
            return B[bStart + k - 1]; // k - 1 because k is 1 based index
        }
        // B array was visited completely, so the result exists in A
        if (bStart >= B.length){
            return A[aStart + k - 1]; // k - 1 because k is 1 based index
        }
        // for each recursion, k will be reduced to k - k/2
        // the min of k is 1, since 1th means the 1th value in the merged array
        if (k == 1){
            return Math.min(A[aStart], B[bStart]);
        }

        // here -1 because index starts at 0, i.e, 1th value is at array[0]
        int aMid = aStart + k/2 - 1;
        int bMid = bStart + k/2 - 1;

        // 
        int aVal = aMid >= A.length ? Integer.MAX_VALUE : A[aMid];
        int bVal = bMid >= B.length ? Integer.MAX_VALUE : B[bMid];

        // the median must exist at the right part of a sorted array
        // so throw the left values of the array that has a smaller submedian
        if (aVal <= bVal){
            return findKthHelper(A, aMid + 1, B, bStart, k - k/2); // scan right part of array A and the whole B
        }else {
            return findKthHelper(A, aStart, B, bMid + 1, k - k/2); // scan right oart if array B and the whole A
        }
    }
}