class Solution {
    public int shortestPathAllKeys(String[] grid) {

        int m = grid.length, n = grid[0].length();
        int[] start = new int[3]; // start[0] is key, start[1] is i, start[2] is j
        int lastKey = 0;
        // find start point and the last key
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    start[1] = i;
                    start[2] = j;
                }
                else if ('a' <= c && c <= 'f') {
                    lastKey |= 1 << (c - 'a');
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start[0] + " " + start[1] + " " + start[2]);
        int step = 0;
        int[][] Ds = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] A = queue.poll();
                for (int[] D: Ds) {
                    int i = A[1] + D[0];
                    int j = A[2] + D[1];
                    int currKey = A[0];
                    if (currKey == lastKey) {return step;}
                    if (i < 0 || i >= m || j < 0 || j >= n) {continue;} // out of grid
                    if (visited.contains(currKey + " " + i + " " + j)) {continue;} // visited
                    char c = grid[i].charAt(j);
                    if (c == '#') {continue;} // wall
                    if ('A' <= c && c <= 'F' && ((currKey >> (c - 'A') & 1) == 0)) {continue;} // no key
                    if ('a' <= c && c <= 'f') {
                        currKey |= (1 << (c - 'a')); // update key
                    }
                    visited.add(currKey + " " + i + " " + j);
                    queue.offer(new int[]{currKey, i, j});
                }

            }
            step++;
        }
        return -1;
    }
}