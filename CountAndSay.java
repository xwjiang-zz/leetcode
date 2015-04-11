//reset count to 1 instead of 0
public class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (j == 0 || s.charAt(j) == s.charAt(j-1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(s.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(s.charAt(s.length()-1));
            s = sb.toString();
        }
        return s;
    }
}

//3/22/2015 recursion
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String s = countAndSay(n-1);
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            int j = i;
            for (; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }
            sb.append(count);
            sb.append(s.charAt(i));
            i = j;
        }
        return sb.toString();
    }
}
