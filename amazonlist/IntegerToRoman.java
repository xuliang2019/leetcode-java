//public class IntegerToRoman {
//    public String intToRoman(int num) {
//        // use map
//        String[] M = {"", "M", "MM", "MMM"}; // 1 <= num <= 3999
//        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
//        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
//        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
//
//        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
//    }
//}

public class IntegerToRoman {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) { return ""; }
        StringBuilder res = new StringBuilder();

        // map roman letters to values
        // notice the values for 900, 400 at each digit
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        int i = 0;
        while (num > 0) {
            while (num >= values[i]) {
                res.append(symbols[i]);
                num -= values[i];
            }
            i++;
        }
        return res.toString();
    }
}