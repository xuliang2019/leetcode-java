 public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // use dp
        // for the first row and first column, they only have one unique path
        // so populate them with 1.
        // for other cells, paths[i][j] can have the sum of paths[i-1][j] and paths[i][j-1]
        // since the robot can reach paths[i][j] only from up side or left side
        // when reaches to the bottom-right, return the value

        if(m <= 0 || n <= 0) {
            return 0;
        }

        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    paths[i][j] = 1;
                }
                else {
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }

            }
        }

        return paths[m-1][n-1];

    }
}