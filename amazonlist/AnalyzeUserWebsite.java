import java.util.*;

 // define a timestamp-website pair class for further sorting
 class Pair {
    int time;
    String web;

    public Pair(int time, String web) {
        this.time = time;
        this.web = web;
    }
}

 public class AnalyzeUserWebsite {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // use a hashmap to store the three arrays information
        // key is username, value is a list of timestamp-website pairs
        HashMap<String, List<Pair>> userMap = new HashMap<String, List<Pair>>();
        int n = username.length;
        for (int i = 0; i < n; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }

        // for each user, count the 3-sequence repeating times
        HashMap<String, Integer> count = new HashMap<>();
        String res = "";
        for (String user: userMap.keySet()) {
            List<Pair> list = userMap.get(user);
            // sort the list by time ascending
            Collections.sort(list, (a, b) -> (a.time - b.time)); // sort by time
            Set<String> set = new HashSet<>(); // avoid same 3-sequences for each user

            // brute force, find all possible 3-sequences for each user and count the sequences repeating times
            for (int i =  0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    for (int k = j+1; k < list.size(); k++) {
                        StringBuilder sb =  new StringBuilder();
                        // current 3-sequences
                        sb.append(list.get(i).web).append(",").append(list.get(j).web).append(",").append(list.get(k).web);
                        String str = sb.toString();
                        // only count when str doesn't repeate
                        if (!set.contains(str)) {
                            // count repeating times
                            count.put(str, count.getOrDefault(str, 0) +  1);
                            // avoid equal 3-sequence
                            set.add(str);
                        }
                        // update res
                        if (res == "" || count.get(str) > count.get(res) || (count.get(str) == count.get(res) && str.compareTo(res) < 0)) {
                            // note the final result is the most common and lexicographically smallest 3-sequence
                            res = str;
                        }
                    }
                }
            }

        }
        // conver res string to list
        return Arrays.asList(res.split(","));
    }

}