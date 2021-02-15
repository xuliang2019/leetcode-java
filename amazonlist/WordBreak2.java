import java.util.*;

public class WordBreak2 {
    // use a hashmap  to save the previous results to prune duplicated branches
    HashMap<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        // convert list to set since set.contains() cost O(1)
        Set<String> set = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (set.contains(s)) {
            res.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String suffix = s.substring(i);
            if (set.contains(suffix)) {
                // find prefix
                List<String> prefixList = wordBreak(s.substring(0, i), wordDict);
                if (prefixList.size() > 0) {
                    // get all satisfying results, combine prefix and suffix
                    for (int j = 0; j < prefixList.size(); j++) {
                        res.add(prefixList.get(j) + " " + suffix);
                    }
                }
            }
        }
        // add current result to map and return current result
        map.put(s, res);
        return res;
    }
}
