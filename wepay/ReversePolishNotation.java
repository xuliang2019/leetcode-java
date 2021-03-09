class Solution {
    public int evalRPN(String[] tokens) {
        // use stack, if encounters operands, pop twice, the first poped value is right, while the sencond value is left
        // do the calculation with the operand
        Stack<Integer> stack = new Stack<>();
        int left  = 0, right = 0;
        int current = 0;
        for (String s: tokens) {
            if (s.equals("+")) {
                right = stack.pop();
                left = stack.pop();
                current = left + right;
                stack.push(current);
            }
            else if (s.equals("-")) {
                right = stack.pop();
                left = stack.pop();
                current = left - right;
                stack.push(current);
            }
            else if (s.equals("*")) {
                right = stack.pop();
                left = stack.pop();
                current = left * right;
                stack.push(current);
            }
            else if (s.equals("/")) {
                right = stack.pop();
                left = stack.pop();
                current = left / right;
                stack.push(current);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}