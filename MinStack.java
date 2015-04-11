class MinStack {
    Stack<Integer> normalStack;
    Stack<Integer> minStack;
    public MinStack() {
        normalStack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    public void push(int x) {
        normalStack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }
    public void pop() {
        if (minStack.peek().intValue() == normalStack.peek().intValue()) {
            minStack.pop();
        }
        normalStack.pop();
    }
    public int top() {
        return normalStack.peek();
    }
    public int getMin() {
        return minStack.peek();
    }
}
