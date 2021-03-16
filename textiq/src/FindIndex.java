import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindIndex {
    public static int[] findIndex(String s, int[] query) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int size = s.length();
        // store all the index for each character
        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int len = query.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            char c = s.charAt(query[i]);
            List<Integer> curList = map.get(c);
            // only contain the char itself
            if (curList.size() == 1) {
                res[i] = -1;
            }
            else {
                res[i] = getNearest(curList, query[i]);
            }
        }
        return res;

    }

    public static int getNearest(List<Integer> list, int value) {
        int size = list.size();
        int res = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            int index = list.get(i);
            int diff = Math.abs(index - value);
            // skip itself
            if (diff == 0) {
                continue;
            }
            if (diff < minDiff) {
                minDiff = diff;
                res = index;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] query = new int[]{2, 3, 7};
        int[] res = findIndex("leetcode", query);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
