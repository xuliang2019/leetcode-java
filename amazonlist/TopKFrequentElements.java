import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // +1 because the max frequency is at the index of nums.length
        List<Integer>[] bucket = new List[nums.length+1];
        List<Integer> res = new ArrayList<>();

        // count frequency
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int key: map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        // filter res
        for (int i = bucket.length-1; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }

        // conver list to array
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}

//public class TopKFrequentElements {
    // time complexity nlogn, minHeap costs logn when adding or deleting
//    public int[] topKFrequent(int[] nums, int k) {
//        // use a hashmap to cout frequency
//        // use a minHeap to store the k frequent nums
//        HashMap<Integer, Integer> map = new HashMap<>();
//        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue().compareTo(b.getValue()));
//
//        for (int n: nums) {
//            int count = map.getOrDefault(n, 0) + 1;
//            map.put(n, count);
//        }
//
//        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
//            minHeap.add(entry);
//            if (minHeap.size() > k) {
//                minHeap.poll();
//            }
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        while (!minHeap.isEmpty()) {
//            Map.Entry<Integer, Integer> entry = minHeap.poll();
//            list.add(entry.getKey());
//        }
//
//        int[] res = new int[k];
//        for (int i = 0; i < k; i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//
//    }
//}