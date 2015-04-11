//remember to deal with the remaining elements in the stack
//a bug?? what if after popping height[top] == height[i]??
public class Solution {
    public int largestRectangleArea(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[i] > height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                    int top = stack.pop();
                    int start = stack.isEmpty() ? 0 : stack.peek() + 1;
                    res = Math.max(res, (i - start)*height[top]);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int start = stack.isEmpty() ? 0 : stack.peek() + 1;
            res = Math.max(res, (height.length - start)*height[top]);
        }
        return res;
    }
}

//3/31/2015
public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int top = stack.pop();
                int start = stack.isEmpty() ? 0 : stack.peek()+1;
                res = Math.max(res, (i - start) * height[top]);
            }
            if (!stack.isEmpty() && height[stack.peek()] == height[i]) {
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int start = stack.isEmpty() ? 0 : stack.peek()+1;
            res = Math.max(res, (height.length - start) * height[top]);
        }
        return res;
    }
}
