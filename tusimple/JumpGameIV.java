class Solution {
    public int minJumps(int[] arr) {
        // use bfs, find the max distance that the current index can reach to (i+1, i-1, j)
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        // populate map, key is arr[i], value is a list of indice of arr[i]
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        Queue<Integer> q = new LinkedList<>(); // store current level index
        boolean[] visited = new boolean[n]; // mark each index is visited or not
        q.add(0); // start from index 0
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int index = q.poll();
                // check if reach to the last index
                if (index == n - 1) {
                    return res;
                }
                List<Integer> indice = map.get(arr[index]);
                // check arr[i] == arr[j] && i != j
                for (int i: indice) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.offer(i);
                    }
                }
                indice.clear(); // clear visited indice
                // check index+1 and index-1
                if (index+1 < n && !visited[index+1]) {
                    visited[index+1] = true;
                    q.offer(index+1);
                }
                if (index-1 >= 0 && !visited[index-1]) {
                    visited[index-1] = true;
                    q.offer(index-1);
                }
            }
            res++;
        }
        return -1;

    }
}

//class Solution {
//    public int minJumps(int[] arr) {
//        int n = arr.length;
//        if (n == 1) return 0;
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for (int i = n-1; i >= 0; i--) {
//            map.putIfAbsent(arr[i], new LinkedList<>());
//            map.get(arr[i]).add(i);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(0);
//
//        int res = 0;
//        while (!queue.isEmpty()) {
//            res++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                int j = queue.poll();
//
//                if (j+1 < n && map.containsKey(arr[j+1])) {
//                    if (j+1 == n-1) return res;
//                    queue.offer(j+1);
//                }
//
//                if (j-1 >= 0 && map.containsKey(arr[j-1])) {
//                    queue.offer(j-1);
//                }
//
//                if (map.containsKey(arr[j])) {
//                    for (int k : map.get(arr[j])) {
//                        if (k != j) {
//                            if (k == n-1) return res;
//                            queue.offer(k);
//                        }
//                    }
//                    map.remove(arr[j]);
//                }
//            }
//        }
//
//        return res;
//    }
//}

/*
    Expain Time O(N): In the case where each index has the same value, the algorithm goes to the neighbor (the same value) once then breaks all the edge by using: next.clear()
    So the algorithm will traverse up to N edges for j and 2N edges for (i+1, i-1).
    That's why time complexity is O(3N) ~ O(N)
 */