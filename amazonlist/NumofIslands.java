public class NumofIslands {
    public int numIslands(char[][] grid) {
        // use dfs, find the area connected by 1 from 4 directions
        // during each search, mark 1 to 0 as visited
        // count the number of areas

        // check input
        if (grid.length == 0 || grid == null) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // start search only when grid[row][col] = 1
                if (grid[row][col] == '1') {
                    findIsland(grid, height, width, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    private void findIsland(char[][] grid, int height, int width, int row, int col) {
        // break dfs conditions
        if (row >= height || row < 0 || col >= width || col < 0 || grid[row][col] == '0') {
            return;
        }
        // mark current point to 0 as visited
        grid[row][col] = '0';
        // search from 4 directions
        findIsland(grid, height, width, row - 1, col);
        findIsland(grid, height, width, row + 1, col);
        findIsland(grid, height, width, row, col - 1);
        findIsland(grid, height, width, row, col + 1);
    }
}