public class ReorganizeString {
    public static String reorganizeString(String S) {
        // Interval Insertion
        // First, find the character with max occurrence frequency
        // insert the character to result array intervaly(every two indice with one insertion, i.e, 0, 2, 4...)
        // insert the rest of characters

        int[] frequency = new int[26];

        // count frequency for each character
        for (int i = 0; i < S.length(); i++) {
            char currChar = S.charAt(i);
            // use ASCII relative encoded index
            frequency[currChar - 'a']++;
        }

        int max = 0;
        char maxChar = 'a';
        // find the character with max frequency
        for (int i = 0; i < frequency.length; i++) {
            if (max < frequency[i]) {
                max = frequency[i];
                maxChar = (char) (i + 'a');
            }
        }

        // edge case: if max is larger than the half size of s, then we can't reorganize it
        // eg: "aaab", "aaa". s.length + 1 is to round up odd string.
        if (max > (S.length() + 1) / 2) {
            return "";
        }

        // insert the maxChar intervally
        char[] res = new char[S.length()];
        int idx = 0;
        while (frequency[maxChar - 'a'] > 0) {
            res[idx] = maxChar;
            frequency[maxChar - 'a']--;
            idx += 2;
        }

        // insert the rest characters
        for (int i = 0; i < frequency.length; i++) {
            while (frequency[i] > 0) {
                // if idx reaches to the last index,
                // set idx back to index 1
                if (idx >= S.length()) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                frequency[i]--;
                idx += 2;
            }
        }
        return String.valueOf(res);

    }

    public static void main(String[] args) {
        String s = "aaa";
        String s2 = "bbbaaacdd";
        System.out.println(reorganizeString(s));
        System.out.println(reorganizeString(s2));
    }
}