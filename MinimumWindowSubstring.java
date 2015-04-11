//complexity analysis
//use countToMatch for unique characters to match
//only update countToMatch when toMatch[ch] goes from 1 to 0 or from 0 to 1
//together with SubstringWithConcatenationOfAllWords
public class Solution {
    /*
    public String minWindow(String S, String T) {
        int[] num = new int[256];
        int[] find = new int[256];
        for (int i = 0; i < 256; i++) {
            num[i] = 0;
            find[i] = 0;
        }
        for (int i = 0; i < T.length(); i++) {
            num[T.charAt(i)]++;
        }
        int count = 0;
        int i = 0;
        int j = 0;
        for (; j < S.length(); j++) {
            char c = S.charAt(j);
            if (num[c] > find[c]) {
                count++;
            }
            find[c]++;
            if (count == T.length()) {
                break;
            }
        }
        if (count < T.length()) {
            return "";
        }
        String res = S.substring(0, ++j);
        while (j <= S.length()) {
            while (i < S.length() && num[S.charAt(i)] < find[S.charAt(i)]) {
                find[S.charAt(i)]--;
                i++;
            }
            if (res.length() > j - i) {
                res = S.substring(i, j);   
            }
            while (j < S.length() && S.charAt(j) != S.charAt(i)) {
                find[S.charAt(j)]++;
                j++;
            }
            i++;
            j++;
        }
        return res;
    }*/
    
    public String minWindow(String S, String T) {
        int[] toMatch = new int[256];
        int countToMatch = 0;
        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            toMatch[ch]++;
            if (toMatch[ch] == 1) {
                countToMatch++;
            }
        }
        int st = 0;
        int en = 0;
        int minSt = 0;
        int minEn = S.length() + 1;
        while (en <= S.length()) {
            if (countToMatch > 0) {
                if (en >= S.length()) {
                    break;
                }
                char ch = S.charAt(en++);
                toMatch[ch]--;
                if (toMatch[ch] == 0) {
                    countToMatch--;
                }
            } else {
                char ch = S.charAt(st++);
                toMatch[ch]++;
                if (toMatch[ch] == 1) {
                    countToMatch++;
                }
            }
            if (countToMatch == 0 && minEn - minSt > en - st) {
                minSt = st;
                minEn = en;
            }
        }
        if (minEn == S.length() + 1) {
            return "";
        }
        return S.substring(minSt, minEn);
    }
}

//3/30/2015
//notice the loop condition!!
//also though not corrected, but avoid the use of two variables whose meanings are not consistent
//like res and minLen here!
//error case is "a"
public class Solution {
    public String minWindow(String S, String T) {
        int[] toMatch = new int[128];
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            toMatch[c]++;
        }
        int countToMatch = T.length();
        String res = "";
        int minLen = S.length();
        int i = 0;
        int j = 0;
        while (countToMatch == 0 || j < S.length()) {
            if (countToMatch > 0) {
                char c = S.charAt(j);
                toMatch[c]--;
                if (toMatch[c] >= 0) {
                    countToMatch--;
                }
                j++;
            } else {
                char c = S.charAt(i);
                toMatch[c]++;
                if (toMatch[c] > 0) {
                    countToMatch++;
                }
                i++;
            }
            if (countToMatch == 0 && minLen >= j - i) {
                minLen = j - i;
                res = S.substring(i, j);
            }
        }
        return res;
    }
}

