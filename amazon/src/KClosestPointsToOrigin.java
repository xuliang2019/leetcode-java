import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        // define a max heap
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            // descending order
            public int compare(int[] left, int[] right) {
                return getDistance(right) - getDistance(left);
            }
        });

        for (int[] p: points) {
            heap.offer(p);
            if (heap.size() > K) {
                heap.poll();
            }
        }

        int[][] res = new int[K][2];
        while(K > 0) {
            res[--K] = heap.poll();
        }

        return res;
    }

    private int getDistance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

// quicksort will be better!