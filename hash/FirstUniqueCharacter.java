class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();

        // count each character repeating times within the string s,
        // keep the original sequence
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // identify the first charcter that only repeat once
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;

    }
}

class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();

        // count each character repeating times
        for (char c: s.toCharArray()) {
            count[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }
}