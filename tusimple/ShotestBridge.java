class Solution {
    public int shortestBridge(int[][] A) {
        // use dfs to find the first island
        // then use bfs to expand the first island until it reaches to the second island
        int m = A.length, n = A[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean found = false;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    dfs(A, visited, i, j, dirs, q);
                    found = true;
                    break;
                }

            }
        }

        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                // expand from 4 directions
                for (int[] dir: dirs) {
                    int i = curr[0] + dir[0];
                    int j = curr[1] + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                        if (A[i][j] == 1) {return step;}
                        q.offer(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }
            step++;
        }
        return -1;

    }

    public void dfs(int[][] A, boolean[][] visited, int i, int j, int[][] dirs, Queue<int[]> q) {
        // check boundary
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0 || visited[i][j]) {
            return;
        }
        // mark A[i][j] visited and add it to q
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        // explore from 4 directions
        for (int[] dir: dirs) {
            dfs(A, visited, i + dir[0], j + dir[1], dirs, q);
        }
    }
}