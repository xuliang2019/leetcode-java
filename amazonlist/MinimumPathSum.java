 public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // use DP, calculate and update the min sum at each grid[i][j]
        int height = grid.length;
        int width = grid[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // start at grid[0][0], the min value is itself
                if (i == 0 && j == 0) { grid[i][j] = grid[i][j]; }
                // top boundary，only consider the left point
                else if (i == 0 && j != 0) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                }
                // left boundary, only consider the top point
                else if (j == 0 && i != 0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                }
                // points in the middle part has two options
                // adjacent left or adjacent top point
                else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j-1], grid[i-1][j]);
                }
            }
        }
        return grid[height-1][width-1];
    }
}