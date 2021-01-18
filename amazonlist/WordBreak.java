import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        // use dp, for each substring in s
        // identify whether it contained in wordDict or not
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict); // set.contains() cost O(1)

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // dp[j] means s.substring(0, j)
                // only the two conditions ensure dp[i] is true
                dp[i] = dp[j] && set.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}
