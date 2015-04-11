//note where to reset res
public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (i == 0 || s.charAt(i-1) == ' ') {
                    res = 1;
                } else {
                    res++;
                }
            }
        }
        return res;
    }
}

//3/29/2015
public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                if (count == 0) {
                    continue;
                }
                res = count;
                count = 0;
            }
        }
        return count == 0 ? res : count;
    }
}
