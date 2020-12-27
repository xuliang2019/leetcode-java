import java.util.PriorityQueue;

public class FiveStarSeller {
    public int fiveStarReviews(int[][] products, int threshold) {
        int total = products.length;
        double curPercent = 0.0;
        double dThreshold = threshold / 100.0 * total;
        PriorityQueue<int[]> pq = new PriorityQueue<>((first, second) -> {
            int a = first[1], b = first[0];
            int c = second[1], d = second[0];
            // First element is b/a, second element is d/c
            // To build a max Heap we need (1 - d/c)(1 / (c + 1)) - (1 - b/a)(1 / (a + 1))
            // After transformation and we only need numerator, we get following equation
            return a * c * (a - c) - a * d * (d + 1) + b * c * (c + 1);
        });
        for (int[] p : products) {
            curPercent += ((double) p[0] / p[1]);
            if (p[1] > p[0]) pq.offer(p);
        }

        int ret = 0;
        while (curPercent < dThreshold) {
            int[] p = pq.poll();
            ret++;
            curPercent += (1 - (double)p[0] / p[1]) * (1.0 / (p[1] + 1));
            p[0]++;
            p[1]++;
            pq.offer(p);
        }
        return ret;

    }

    public static void main(String[] args) {
        FiveStarSeller obj = new FiveStarSeller();
        int[][] products = {{4, 4}, {1, 2}, {3, 6}};
        assert(obj.fiveStarReviews(products, 77) == 3);
    }
}