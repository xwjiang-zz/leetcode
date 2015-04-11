/*
slashes together
handle the case that these is no slash at the end
what if the number of "." more than the number of hierarchy available -->ignore
*/
public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        int start = 0;
        while (start < path.length() && path.charAt(start) == '/') {
            start++;
        }
        int end = start;
        while (end < path.length()) {
            if (end+1 == path.length() || path.charAt(end+1) == '/') {
                String token = path.substring(start, end+1);
                start = end+2;
                while (start < path.length() && path.charAt(start) == '/') {
                    start++;
                }
                end = start;
                if (token.equals(".")) {
                    continue;
                } else if (token.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(token);
                }
            } else {
                end++;
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return sb.toString();
    }
}

//3/30/2015
public class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.length() == 0 || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, "/" + stack.pop());
        }
        return res.toString();
    }
}
