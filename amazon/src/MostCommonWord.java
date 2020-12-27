import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        // filter banned words
        Set<String> bannedWords = new HashSet<>();
        for (String word: banned) {
            bannedWords.add(word);
        }

        // convert paragraph to char array
        char[] chars = paragraph.toCharArray();
        int n = chars.length;
        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0;
        String res = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char currChar = chars[i];
            // join chars to a complete word,
            // skip when ecounters punctuation or white space
            if (Character.isLetter(chars[i])) {
                // the answer is lowercase
                sb.append(Character.toLowerCase(currChar));
                if (i != n - 1) {
                    continue;
                }
            }
            // determine most frequency words
            if (sb.length() > 0) {
                // convert to string
                String currWord = sb.toString();

                // compare the max frequency word that not included in bannedWords
                if (!bannedWords.contains(currWord)) {
                    // count current word frequency
                    map.put(currWord, map.getOrDefault(currWord, 0) + 1);
                    int currMax = map.get(currWord);
                    if (currMax > maxCount) {
                        maxCount = currMax;
                        res = currWord;
                    }
                }
                sb = new StringBuilder();
            }
        }
        return res;


    }
}