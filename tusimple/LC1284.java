class Solution {
    private final int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // five cells, itself and four neighbors
    public int minFlips(int[][] mat) {
        int start = 0, m = mat.length, n = mat[0].length;
        // covert mat to an int using binary expression
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start |= mat[i][j] << (i * n + j); // eg 0b1000
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>(Arrays.asList(start));
        Set<Integer> visited = new HashSet<Integer>(queue);
        for (int step = 0; !queue.isEmpty(); step++) {
            for (int size = queue.size(); size > 0; size--) {
                int current = queue.poll();
                if (current == 0) {return step;} // All 0s matrix found. eg: 0b0000
                // flip current m*n matrix
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int next = current;
                        // for each cell, flip itself and its neighbors
                        for (int[] dir: dirs) {
                            int row = i + dir[0];
                            int col = j + dir[1];
                            if (row >= 0 && row < m && col >= 0 && col < n) {
                                next ^= 1 << (row * n + col);
                            }
                        }
                        // check duplicates
                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}