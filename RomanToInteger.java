public class Solution {
    public int romanToInt(String s) {
        int num = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            if (j == s.length() || map.get(s.charAt(i)) >= map.get(s.charAt(j))) {
                num += map.get(s.charAt(i));
                i++;
            } else {
                num = num - map.get(s.charAt(i)) + map.get(s.charAt(j));
                i += 2;
            }
        }
        return num;
    }
}
