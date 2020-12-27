public class GiftingGroups {
    public int findCircleNum(int[][] M) {
        //visited[i] means if ith person is visited in this algorithm
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, boolean[] visited, int person) {
        // iterate all the people
        for (int other = 0; other < M.length; other++) {
            //We found an unvisited person in the current friend cycle
            if (M[person][other] == 1 && !visited[other]) {
                visited[other] = true;
                //Start DFS on this new found person
                dfs(M, visited, other);
            }
        }
    }
}