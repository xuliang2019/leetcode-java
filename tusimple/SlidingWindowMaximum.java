class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] res = new int[n-k+1];
        int index = 0;
        // use a deque to store the index of array a
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // for each window, the range is [i-k+1, i]
            // remove numbers out of range k(left part)
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range from right to left
            // ensure the largest value index at the head of the deque
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            q.offer(i);
            // the res array begins to add element only when i >= k - 1
            // i.e. the last index of the first window
            if (i >= k - 1) {
                res[index++] = a[q.peek()];
            }
        }
        return res;
    }
}