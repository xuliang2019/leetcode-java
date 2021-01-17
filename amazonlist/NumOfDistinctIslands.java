import java.util.HashSet;
import java.util.Set;

public class NumOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        // use dfs, find the area connected by 1 from 4 directions
        // for each area, encode it as a string called dir
        // during each search, mark 1 to 0 as visited, append current search direction to string dir
        // count the number of distinct strings

        int height = grid.length;
        int width = grid[0].length;
        Set<String> set = new HashSet<>();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                // only search when grid[row][col] = 1
                if (grid[row][col] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, height, width, row, col, sb, "s");
                    // each sb will be "sxxxe"; s means start, e means end
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int height, int width, int row, int col, StringBuilder sb, String dir) {
        if (row < 0 || row >= height || col < 0 || col >= width || grid[row][col] == 0) {
            return;
        }

        sb.append(dir);
        grid[row][col] = 0;

        dfs(grid, height, width, row + 1, col, sb, "u");
        dfs(grid, height, width, row - 1, col, sb, "b");
        dfs(grid, height, width, row, col + 1, sb, "r");
        dfs(grid, height, width, row, col - 1, sb, "l");
        // end point
        sb.append("e");
    }
}