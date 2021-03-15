import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//public class AllPalindromicSubstring {
//
//    /*
//
//    The idea is to simply pick every character and move both the sides till
//    the characters are same on the end. If they are not, then you break of
//    the loop because if the substring is not a palindrome than the bigger
//    string will not be a plaindrome too. TimeComplexity: O(n^2). Brute force
//    is O(n^3). Generation of all substring of a string is itself O(n^2),
//    hence this is an optimal solution.
//    */
//    public static Set printAll(String s) {
//        Set res = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            StringBuilder sb = new StringBuilder();
//            int j = i, k = i + 1;
//            res.add(s.charAt(i) + "");
//            for (int it = 0; it < 2; it++) {
//                if (it == 1) {
//                    j = i - 1;
//                    k = i + 1;
//                    sb.setLength(0);
//                    sb.append(s.charAt(i));
//                }
//                while (j >= 0 && k < s.length()) {
//                    if (s.charAt(j) == s.charAt(k)) {
//                        sb.insert(0, s.charAt(j));
//                        res.add(sb.append(s.charAt(k)).toString());
//                        j--;
//                        k++;
//                    } else
//                        break;
//                }
//            }
//        }
//        return res;
//    }
//    public static void main(String[] args) {
//        Set<String> set = printAll("abcbad");
//        for (String str : set) {
//            System.out.println(str);
//        }
//    }
//
//}

public class AllPalindromicSubstring {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            int odd = helper(s, i, i, list);
            int even = helper(s, i, i + 1, list);
            res += odd + even;
        }
        System.out.println(list.toString());
        return res;
    }

    private int helper(String s, int left, int right, List<String> list) {
        if (left < 0 || right > s.length()) {return 0;}
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                list.add(s.substring(left, right + 1));
            }
            else {
                break;
            }
            left--;
            right++;
        }
        return count;
    }
}