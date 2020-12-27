import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        // since we need to poll redundant elements from min heap,
        // the comparator is the opposite of the question constrains when frequencies are equal
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        List<String> res = new ArrayList<>();

        // count each word frequency
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // insert map to pq
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            // remove redundant entry
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // append all the elements in pq to res list
        while (!pq.isEmpty()) {
            // notice here, we need to specify the location of insertion
            // due to the descending alphabet sequence in pq
            res.add(0, pq.poll().getKey());
        }

        return res;
    }
}