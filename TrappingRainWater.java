//use stack
//notice that the elements is in the order of first increasing and then decreasing
//better solution at https://github.com/leetcoders/LeetCode/blob/master/TrappingRainWater.h
public class Solution {
    public int trap(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<Integer>();
        int[] sum = new int[n+1];
        sum[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + A[i];
            if (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                while (!stack.isEmpty() && A[stack.peek()] != max && A[i] > A[stack.peek()]) {
                    stack.pop();
                }
            }
            stack.push(i);
            max = Math.max(max, A[i]);
        }
        int res = 0;
        while (stack.size() > 1) {
            int top = stack.pop();
            int secTop = stack.peek();
            res += Math.min(A[top], A[secTop])*(top - secTop - 1) - (sum[top] - sum[secTop] - A[secTop]);
        }
        return res;
    }
}
//3/30/2015
//no nasty +1/-1
//the height is counted when popped
public class Solution {
    public int trap(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        int sum = 0;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            while (stack.size() >= 2 && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            if (stack.size() == 1 && A[stack.peek()] <= A[i]) {
                int top = stack.pop();
                res += A[top] * (i - top);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (stack.size() == 0) {
                res += A[top];
            } else {
                res += A[top] * (top - stack.peek());
            }
        }
        return res - sum;
    }
}
