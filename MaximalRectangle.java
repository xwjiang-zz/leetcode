//notice that the final element is 0. So we don't need to empty the stack after the for loop
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[] height = new int[n+1];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
            }
            Stack<Integer> stack = new Stack<Integer>();
            for (int j = 0; j < n + 1; j++) {
                if (stack.isEmpty() || height[stack.peek()] < height[j]) {
                    stack.push(j);
                } else if (height[stack.peek()] == height[j]) {
                    stack.pop();
                    stack.push(j);
                } else {
                    while (!stack.isEmpty() && height[stack.peek()] >= height[j]) {
                        int top = stack.pop();
                        int start = (stack.isEmpty()) ? 0 : stack.peek() + 1;
                        res = Math.max(res, height[top]*(j - start));
                    }
                    stack.push(j);
                }
            }
        }
        return res;
    }
}
