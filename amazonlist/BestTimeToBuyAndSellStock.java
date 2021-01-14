 public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // check input
        if (prices.length < 2 || prices == null) {
            return 0;
        }

        int min = prices[0]; // very import here, make it the first purchase price
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // seek a lower price to buy
            if (prices[i] < min) {
                min = prices[i];
            }
            // count current max profit
            else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}