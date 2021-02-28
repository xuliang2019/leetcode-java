class Solution {
    public int calculate(String s) {
        // use a switch that contains + - * / cases
        int sum = 0;
        int currSum = 0;
        int num = 0;
        int len = s.length() - 1;
        char lastOperation = '+';

        for (int i = 0; i <= len; i++) {
            char c = s.charAt(i);
            boolean isInteger = Character.isDigit(c);
            //parse current number if c is not operation symbol
            if (isInteger) {
                int currNum = c - '0'; // ASCII relative location
                num = num * 10 + currNum;
            }
            if (i == len || !isInteger && c != ' ') {
                switch(lastOperation) {
                    case '+':
                        sum += currSum;
                        currSum = num;
                        break;
                    case '-':
                        sum += currSum;
                        currSum = -num;
                        break;
                    case '*':
                        currSum *= num;
                        break;
                    case '/':
                        currSum /= num;
                        break;
                }
                // reset num and update lastOperation
                num = 0;
                lastOperation = c;
            }
        }
        sum += currSum;
        return sum;

    }
}

class Solution {
    public int calculate(String s) {
        // check input
        if (s.length() == 0) {return 0;}
        int sum = 0;
        int num = 0;
        int len = s.length() - 1;
        char lastOperation = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= len; i++) {
            char c = s.charAt(i);
            boolean isInteger = Character.isDigit(c);
            if (isInteger) {
                int currNum = c - '0';
                num = num * 10 + currNum;
            }
            if (i == len || !isInteger && c != ' ') {
                if (lastOperation == '+') {
                    stack.push(num);
                }
                if (lastOperation == '-') {
                    stack.push(-num);
                }
                if (lastOperation == '*') {
                    int product = stack.pop() * num;
                    stack.push(product);
                }
                if (lastOperation == '/') {
                    int quotient = stack.pop() / num;
                    stack.push(quotient);
                }
                lastOperation = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}