class Solution {
    public int orangesRotting(int[][] grid) {
        // check input
        if (grid.length == 0 || grid[0].length == 0) {return -1;}
        int m = grid.length, n = grid[0].length;
        int freshCount = 0, time = 0;
        Queue<int[]> q = new LinkedList<>();
        // put rotten oranges to q and count fresh oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // use bfs to count the total elasing time
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!q.isEmpty()) {
            // check remaining fresh oranges
            if (freshCount == 0) {return time;}
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = q.poll();
                // infect fresh oranges from 4 directions
                for (int[] dir: dirs) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    // check boundary
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
                        continue;
                    }
                    // add new rotten orange to q and update remaing fresh oranges count
                    grid[x][y] = 2;
                    q.add(new int[]{x, y});
                    freshCount--;
                }
            }
            time++;
        }
        // check impossible case by freshCount
        return freshCount == 0 ? time : -1;
    }
}