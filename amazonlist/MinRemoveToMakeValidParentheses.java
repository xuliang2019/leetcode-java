import java.util.Stack;

public class MinRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    // mark ')' as '*'
                    sb.setCharAt(i, '*');
                }
            }
        }

        while (!stack.isEmpty()) {
            // mark '(' as '*'
            int loc = stack.pop();
            sb.setCharAt(loc, '*');
        }

        String res = sb.toString();
        // remove all the marked '*'
        res = res.replace("*", "");

        return res;
    }
}