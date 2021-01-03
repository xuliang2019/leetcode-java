import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        // use fast and slow pointers
        // put symbol value pair to hashmap
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Character[] symbols = new Character[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] values = new int[]{1, 5, 10, 50, 100, 500, 1000};
        for (int i = 0; i < symbols.length; i++) {
            map.put(symbols[i], values[i]);
        }

        int pre = 0;
        int curr = 0;
        int res = 0;
        int n = s.length() - 1;
        for (int i = n; i >= 0; i--) {
            char c = s.charAt(i);
            curr = map.get(c);
            // scan from back to front
            // if curr < pre, res - curr
            if (curr < pre) {
                res -= curr;
            }
            else {
                res += curr;
            }
            pre = curr;
        }

        return res;
    }
}