public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<Character>();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            } else {
                set.remove(s.charAt(i++));
            }
            res = Math.max(res, j-i);
        }
        return res;
    }
}
