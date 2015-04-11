public class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return false;
        }
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }
        if (i > j) {
            return false;
        }
        return _isNumber(s.substring(i, j+1));
    }
    public boolean _isNumber(String s) {
        int state = 0; //1: '.' 2: 'x' 3: '?.x' 4: 'x.'
        int i = 0;
        while (i < s.length() && (s.charAt(i) == '.' || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
            if (s.charAt(i) == '.') {
                if (state == 0) {
                    state = 1;
                    i++;
                } else if (state == 2) {
                    state = 4;
                    i++;
                } else {
                    return false;
                }
            } else {
                if (state == 0) {
                    state = 2;
                    i++;
                } else if (state == 1 || state == 4) {
                    state = 3;
                    i++;
                } else {
                    i++;
                }
            }
        }
        if (i == s.length()) {
            if (state == 1) {
                return false;
            } else {
                return true;
            }
        }
        if (s.charAt(i) != 'E' && s.charAt(i) != 'e') {
            return false;
        }
        i++;
        if (state != 2 && state != 3 && state != 4) {
            return false;
        }
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        if (i == s.length()) {
            return false;
        }
        while (i < s.length() && s.charAt(i) <= '9' && s.charAt(i) >= '0') {
            i++;
        }
        return i == s.length();
    }
}
