//if simply just use a string map, then there is out of memory error
//precedence: use parenthesis!
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Integer, Integer> occurance = new HashMap<Integer, Integer>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        List<String> res = new ArrayList<String>();
        if (s.length() < 10) {
            return res;
        }
        int number = 0;
        for (int i = 0; i < 10; i++) {
            number = (number << 2) | map.get(s.charAt(i));
        }
        occurance.put(number, 1);
        for (int i = 0; i < s.length() - 10; i++) {
            number = ((number << 2) & 0xFFFFF) | map.get(s.charAt(i+10));
            if (!occurance.containsKey(number)) {
                occurance.put(number, 1);
            } else if (occurance.get(number) == 1) {
                occurance.put(number, 2);
                res.add(s.substring(i+1, i+11));
            }
        }
        return res;
    }
}
