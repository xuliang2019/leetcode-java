import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/discuss/interview-question/344976/Amazon-or-OA-2019-or-Substrings-of-size-K-with-K-distinct-chars
public class KSubstring {

    public static List<String> kSubstring(String s, int k) {
        // sliding window with two pointers
        Set<Character> window = new HashSet<>();
        Set<String> res = new HashSet<>();

        for (int l = 0, r = 0; r < s.length(); r++) {
            // remove repeated characters in sliding window
            // from left to right
            for (; window.contains(s.charAt(r)); l++) {
                window.remove(s.charAt(l));
            }

            // append current character to window
            window.add(s.charAt(r));

            // append satisfied substring to res
            if (window.size() == k) {
                res.add(s.substring(l, r + 1));
                // remove current the leftmost element in sliding window
                // and update the left pointer position
                window.remove(s.charAt(l++));
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        System.out.println(kSubstring("awaglknagawunagwkwagl", 4));
    }
}