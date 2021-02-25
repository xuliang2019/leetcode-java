/*
    test 9
    There are n people in a row. They must all be divided into m contiguous groups from left to right. If each group
    must be at least as large as the group to its left, determine how many distinct ways groups can be formed.
    For a group to be distinct, it must differ in size for at least one group when sorted ascending.
    For example, [1, 1, 1, 3] is distinct from [1, 1, 1, 2] but not from [1, 3, 1, 1].

    Example
    Input:
    8
    4
    Output: 5
    Explanation: [1, 1, 1, 5], [1, 1, 2, 4], [1, 1, 3, 3], [1, 2, 2, 3], [2, 2, 2, 2]
    Notice
    1≤n,m≤200
    https://blog.csdn.net/roufoo/article/details/104901535
**/

class Solution {
    /**
     * @param n: the number of people
     * @param m: the number of groups
     * @return: the number of grouping options
     */
    public int groupingOptions(int n, int m) {
        if (n < m) {
            return 0;
        }

        int[][] dp = new int[n+1][m+1];
        //dp[i][j] is the number of options that i people are divided into j groups
        // two cases: 1) contians 1; 2) not contain 1, i.e larger or equal to 2
        for (int i = 1; i <= m; i++) {
            // dp[i][i] means divide i people to i gropus
            // each group have 1 person, so dp[i][i] = 1
            dp[i][i] = 1;
        }

        // i starts at 2 since j < i, if i starts at 1, then j becomes 0, makes no sense
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {  // the group size is within m, min ends the loop in advance
                dp[i][j] = dp[i-1][j-1] + dp[i-j][j];
            }
        }
        return dp[n][m];
    }
};