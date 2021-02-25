class Solution {
    public int change(int amount, int[] coins) {
        // use dp idea, dp[i] means the number of combination ways to get amount i
        int[] dp = new int[amount + 1];
        dp[0] = 1; // each coin has 1 way to form amount coin

        for (int coin: coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
                //1) we can not use the ith coin and just i-1 coins can sum up to the amount
                //2) we can use the ith coin and need to calculate( amount - amount of ith coin ) has how many ways
            }
        }
        return dp[amount];


    }
}