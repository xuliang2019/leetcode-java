import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        // 1. Hashmap<sum[0,i - 1], frequency>
        //2. sum[i, j] = sum[0, j] - sum[0, i - 1]    --> sum[0, i - 1] = sum[0, j] - sum[i, j]
        //          k           sum      hashmap-key     -->  hashmap-key  =  sum - k
        int sum = 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        // at this point, sum[0, j] = sum[i, j] + sum[0, i-1]
        //                   sum          k       hashmap-key = 0
        // this case is also a satisfying rule, so the frequency is 1

        for (int i: nums) {
            sum += i;
            int preSum = sum - k;
            if (map.containsKey(preSum)) {
                res += map.get(preSum);
            }
            // put preSum to map for further check
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return res;
    }
}