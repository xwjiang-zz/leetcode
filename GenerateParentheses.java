//the same as "phone number" problem
//sb.delteCharAt() method!
//iteration method: https://github.com/azheanda/leetcode/blob/master/generateparentheses.java
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        generateParenthesisRecur(n, 0, 0, sb, result);
        return result;
    }
    public void generateParenthesisRecur(int n, int i, int j, StringBuilder sb, List<String> result) {
        if (i == n && j == n) {
            result.add(sb.toString());
            return;
        } else if (i == j) {
            sb.append("(");
            generateParenthesisRecur(n, i + 1, j, sb, result);
            sb.deleteCharAt(i+j);
        } else if (i == n) {
            sb.append(")");
            generateParenthesisRecur(n, i, j + 1, sb, result);
            sb.deleteCharAt(i+j);
        } else {
            sb.append("(");
            generateParenthesisRecur(n, i+1, j, sb, result);
            sb.deleteCharAt(i+j);
            sb.append(")");
            generateParenthesisRecur(n, i, j+1, sb, result);
            sb.deleteCharAt(i+j);
        }
    }
}
//3/21/2015
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        StringBuilder path = new StringBuilder();
        gp(n, n, path, res);
        return res;
    }
    public void gp(int i, int j, StringBuilder path, List<String> res) {
        if (i == 0 && j == 0) {
            res.add(path.toString());
            return;
        }
        if (i > j) {
            return;
        }
        if (i > 0) {
            path.append('(');
            gp(i-1, j, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if (j > 0) {
            path.append(')');
            gp(i, j-1, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
