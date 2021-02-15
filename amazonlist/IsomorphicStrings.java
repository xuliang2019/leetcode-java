

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        // use an array(ASCII range is 256)
        int[] a1 = new int[256];
        int[] a2 = new int[256];

        // for each character in string s and t,
        // use the character as the index in a1 and a2
        // assign current i to each of a1[s[i]], a2[t[i]]
        // then iterate to compare the value of a1[s[i]], a2[t[i]]

        for (int i = 0; i < s.length(); i++) {
            // when character repeats, 
            // this step update the repeated character value in a1 and a2 arrays
            a1[s.charAt(i)] = i;
            a2[t.charAt(i)] = i;
        }

        // check structure
        for (int i = 0; i < s.length(); i++) {
            if (a1[s.charAt(i)] !=  a2[t.charAt(i)]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "abb"));
    }
}