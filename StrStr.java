public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int[] lpp = new int[needle.length()];
        populateLPP(needle, lpp);
        int i, j;
        for (i = 0, j = 0; i < haystack.length();) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                } else {
                    i++;
                    j++;
                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lpp[j-1];
                }
            }
        }
        return -1;
    }
    
    public void populateLPP(String needle, int[] lpp) {
        lpp[0] = 0;
        int len = 0;
        for (int i = 1; i < needle.length(); i++) {
            if (needle.charAt(i) == needle.charAt(len)) {
                lpp[i] = ++len;
            } else {
                while (len != 0) {
                    len = lpp[len - 1];
                    if (needle.charAt(i) == needle.charAt(len)) {
                        lpp[i] = ++len;
                        break;
                    }
                }
                if (len == 0) {
                    lpp[i] = 0;
                }
            }
        }
    }

}

//3/21/2015
public class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int[] pattern = formPattern(needle);
        while (i < haystack.length() && j < needle.length()) {
            while (j >= 0) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    break;
                } else {
                    j = pattern[j];
                }
            }
            i++;
            j++;
        }
        if (j == needle.length()) {
            return i - j;
        } else {
            return -1;
        }
    }
    public int[] formPattern(String p) {
        int[] res = new int[p.length()];
        int matched = -1;
        for (int i = 0; i < p.length(); i++) {
            res[i] = matched;
            while (matched >= 0) {
                if (p.charAt(i) == p.charAt(matched)) {
                    break;
                } else {
                    matched = res[matched];
                }
            }
            matched++;
        }
        return res;
    }
}
