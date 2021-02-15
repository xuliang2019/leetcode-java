import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.min = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);

        // add min value to min stack
        // if min stack is empty, just add x
        // if not, only add x if x < min.peek()
        if (min.empty()) {
            min.add(x);
        }
        else if (!min.empty() && x <= min.peek()) {
            min.add(x);
        }
    }

    public void pop() {
        int value = stack.pop();
        // sync min stack only if value in min stack
        // if min stack is empty, skip pop
        if (!min.empty() && min.peek() == value) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */