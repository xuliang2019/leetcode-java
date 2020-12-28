import java.util.*;

public class TransactionLogs {
    public static List<String> getFraudIds (String[] input, int threshold) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String log: input) {
            String[] logDetail = log.split(" ");
            Set<String> set = new HashSet<>();

            // add userId to set
            set.add(logDetail[0]);
            set.add(logDetail[1]);

            // count each userId frequency
            for (String userId: set) {
                map.put(userId, map.getOrDefault(userId, 0) + 1);
            }
        }

        // filter userId that reaches to threshold
        for (String userId: map.keySet()) {
            if (map.get(userId) >= threshold) {
                res.add(userId);
            }
        }

        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"345366 89921 45", "029323 38239 23",
                    "345366 38239 23", "029323 345366 13", "38239 38239 23"};
        System.out.println(getFraudIds(input, 3));
    }
}
