 public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }

        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1; // for the case [[0,0]], the first column has 1 unique path

        for (int[] row: obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    // obstacle, all counted paths are invalid now
                    dp[j] = 0;
                }
                // ginore j = 0 case since we have already assign dp[0] to 1
                else if (j > 0) {  // if j == 0, it means the first column, the unique path count won't change
                    dp[j] += dp[j-1];
                    // new dp[j] = old dp[j] + dp[j-1]
                    //             top cell  + left cell
                }
            }
        }
        return dp[width-1];
    }
}