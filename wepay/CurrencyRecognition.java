// return 1 if dollars, 2 if euros, 3 if japanese yen, -1 not any one
class Solution{
    public int getCurrencyType(String s) {
        if (s.indexOf("$") != -1) { // size 1
            return 1;
        }
        else if (s.indexOf("€") != -1) { // size 3, todo copy symbol from question
            return 2;
        }
        else if (s.indexOf("¥") != -1) { // size 3
            return 3;
        }
        return -1;
    }

    public boolean isPositive(String s) {
        int currencyType = getCurrencyType(s);
        if (currencyType == -1) { return false;}
        int l = 0;
        int r = s.length() - 1;

        if (currencyType == 1) {
            l = 1; // skip '$' with 1 byte
        }
        else {
            l = 3; // skip euros or japanese yen with 3 bytes
        }

        boolean thousandSeparator = false; // ','
        int prevPosition = s.length(); // previous thousand separator (from left to right)

        for (int i = r; i >= l; --i) {
            // if thousand separator present, they must be present at each thousands increment
            // one "," every three digits
            char c = s.charAt(i);
            if (thousandSeparator && (prevPosition - i - 1 == 3 && c != ',')) {
                return false;
            }
            if (Character.isDigit(c)) {
                continue;
            }
            else if (c == '.') {
                // japanese yen do not have cents or not exactly two digits of precision
                if (currencyType == 3 || (r - i != 2)) {
                    return false;
                }
                prevPosition = i;
            }
            else if (c == ',') {
                if (prevPosition - i - 1 != 3) {
                    return  false;
                }
                thousandSeparator = true;
                prevPosition = i;
            }
            else {
                return false;
            }
        }
        if (s.charAt(l) == '0') {
            // leading zero
            if (l == r) {
                return true; // like "$0"
            }
            if (s.charAt(l+1) != '.') {
                return false; // "$000.25"
            }
        }
        return true;

    }

    public boolean isCurrency(String strAmount) {
        int len = strAmount.length();
        int l = 0;
        int r = len - 1;
        if (len == 0 || strAmount.charAt(l) == ' ' || strAmount.charAt(r) == ' ') {
            return false; // empty string or leading or trailing whitespace
        }


        if (strAmount.charAt(l) == '-') {
            l++; // skip negative signal
        }
        else if (strAmount.charAt(l) == '(' || strAmount.charAt(r) == ')') {
            l++;
            r--; // skip parentheses
        }
        return isPositive(strAmount.substring(l, r - l + 1));

    }
}