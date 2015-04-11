/*
solution 1: dp records the length of longest parenthesis ending at index i
            stack records the index of unmatched '('
            end is the last index before the stack is filled again
Solution 2: the same thought but more concise

*/

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        int[] dp = new int[s.length()];
        int end = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (stack.isEmpty()) {
                    end = i-1;
                }
                stack.push(i);
                dp[i] = 0;
            } else {
                if (stack.isEmpty()) {
                    stack.clear();
                    dp[i] = 0;
                } else {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        dp[i] = i - stack.peek();
                    } else {
                        dp[i] = i - end;
                        if (end != -1) {
                            dp[i] += dp[end];
                        }
                    }
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}

class Solution {
public:
    int longestValidParentheses(string s) {
        return longestValidParentheses_1(s);
    }
    
    // push the length of last valid parentheses into stack.
    int longestValidParentheses_1(string s) {
        stack<int> stk;
        int res = 0, count = 0;
        for(int i = 0; i < s.size(); ++i) {
            if (s[i] == '(') {
                stk.push(count);
                count = 0;
            } else if (!stk.empty()) {
                count += (1 + stk.top());
                stk.pop();
                res = max(res, count);
            } else {
                count = 0;
            }
        }
        return res * 2;
    }
};
