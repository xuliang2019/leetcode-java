import java.util.Arrays;
//
//public class BidderStock {
//    public int[] getBuyer(int[][] data, int shares) {
//
//    }
//
//    public static void main(String args[]) {
//        int[][] data = new int[][]{{1, 5, 5, 1}, {2, 7, 7, 3}, {3, 7, 5, 2}, {4, 10, 3, 0}};
//    }
//}

//        # initial public offer
//        # bids: userid, num of shares, bidding price, timestamp
//        import collections
//        def main(bids, totalShare):
//        initial = {}
//        priceBids = collections.defaultdict(list)
//        prices = []
//        # parse data
//        for b in bids:
//        initial[b[0]] = b[1]
//        priceBids[b[2]].append(b)
//        prices.append(b[2])
//
//        # sort by timestamp ascending
//        for price in priceBids:
//        priceBids[price].sort(key=lambda x: x[3])
//
//        # sort by price descending
//        prices = sorted(prices, reverse=True)
//        for price in prices:
//        if totalShare == 0:
//        break
//        currentBids = priceBids[price]
//        if len(currentBids) == 1:
//        currentBid = currentBids[0]
//        assigned = currentBid[1] if currentBid[1] < totalShare else totalShare
//        currentBid[1] -= assigned
//        totalShare -= assigned
//        else:
//        while totalShare > 0 and any(bid[1] > 0 for bid in currentBids):
//        for bid in currentBids:
//        if totalShare == 0:
//        break
//        if bid[1] == 0:
//        continue
//        bid[1] -= 1
//        totalShare -= 1
//
//        print(bids)
//        res = []
//        for b in bids:
//        if b[1] == initial[b[0]]:
//        res.append(b[0])
//        return sorted(res)
//
//        print(main([[1, 2, 5, 0], [2, 1, 4, 2], [3, 5, 4, 6]],3))