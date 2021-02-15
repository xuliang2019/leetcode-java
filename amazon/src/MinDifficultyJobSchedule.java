public class MinDifficultyJobSchedule {
    public int minDifficulty(int[] A, int D) {
        // bottom up
        int n = A.length, inf = Integer.MAX_VALUE, maxd;
        if (n < D) return -1;

        long[] dp = new long[n + 1];
        // prefill dp array with MAX_VALUE except the last element
        // due to we need update dp[0] with the last element
        for (int i = 0; i < n; i++) {
            dp[i] = inf;
        }

        // iterate days to get the total min difficulties within current passed days
        for (int d = 1; d <= D; d++) {
            // n -d means we can't assign a work over two days
            // this loop update the total dp array for each day
            for (int i = 0; i <= n - d; i++) {
                maxd = 0;
                dp[i] = inf;
                // this loop update the min difficulty of dp[i]
                for (int j = i; j <= n - d; j++) {
                    maxd = Math.max(maxd, A[j]);
                    dp[i] = Math.min(dp[i], maxd + dp[j+1]);

                }

            }
        }
        return (int) dp[0];
    }
}