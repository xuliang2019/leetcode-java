import java.util.*;

public class ShoppingPatterns {
    public static void main(String[] args) {
        int productNode = 5;
        List<Integer> productsFrom = Arrays.asList(1, 1, 2, 2, 3, 4);
        List<Integer> productsTo = Arrays.asList(2, 3, 3, 4, 4, 5);
        System.out.println(getMinScore(productNode, productsFrom, productsTo));
    }

    public static int getMinScore(int productNode, List<Integer> productsFrom, List<Integer> productsTo) {
        Set<Integer>[] G = new HashSet[productNode + 1]; // vertices [1, ... 6]
        for (int i = 0; i < G.length; i++) {
            G[i] = new HashSet<>();
        }

        for (int i = 0; i < productsFrom.size(); i++) {
            int from = productsFrom.get(i), to = productsTo.get(i);
            G[from].add(to);
            G[to].add(from);
        }

        int res = Integer.MAX_VALUE;
        for (int v = 1; v < G.length; v++) {
            Set<Integer> set = G[v];
            if (set.size() >= 2) {
                List<Integer> list = new ArrayList<>(set);
                for (int i = 0; i < list.size(); i++) {
                    int p = list.get(i);
                    for (int j = i + 1; j < list.size(); j++) {
                        int q = list.get(j);
                        // found trio; myself(v) is connected to two p&q,
                        // and p&q are connected to themselves. It makes trio
                        if (G[p].contains(q)) {
                            int cost = G[v].size() + G[p].size() + G[q].size() - 6;
                            res = Math.min(res, cost);
                        }
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
