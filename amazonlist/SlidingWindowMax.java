import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if (n * k == 0) return new int[0];
//
//        int [] output = new int[n - k + 1];
//        for (int i = 0; i < n - k + 1; i++) {
//            int max = Integer.MIN_VALUE;
//            for(int j = i; j < i + k; j++)
//                max = Math.max(max, nums[j]);
//            output[i] = max;
//        }
//        return output;
//    }
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {  // only when i - k + 1 >= 0 begins to store max value
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}