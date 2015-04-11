public class Solution {
    public int atoi(String str) {
        long num = 0;
        int tag = 1;
        int i = 0;
        if (i < str.length() && str.charAt(i) == ' ') {
            while (str.charAt(i) == ' ' && i < str.length()) {
                i++;
            }
        }
        if (i == str.length()) {
            return 0;
        }
        if (str.charAt(i) == '-') {
            tag = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        if (i >= str.length() || (str.charAt(i) < '0' || str.charAt(i) > '9')) {
            return 0;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            num *= 10;
            num += (str.charAt(i) - 48) * tag;
            i++;
            if (num < -2147483648L) {
                return Integer.MIN_VALUE;
            } else if (num > 2147483647L) {
                return Integer.MAX_VALUE;
            }
        }
        return (int)num;
    }
}
