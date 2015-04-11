//http://www.lifeincode.net/programming/leetcode-letter-combinations-of-a-phone-number-java/
//try iteration next time, it's also very neat!!
public class Solution {
    public Map<Integer, String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<Integer, String>();
        map.put(0, "abc");
        map.put(1, "def");
        map.put(2, "ghi");
        map.put(3, "jkl");
        map.put(4, "mno");
        map.put(5, "pqrs");
        map.put(6, "tuv");
        map.put(7, "wxyz");
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        letterCombinationsRecur(digits, 0, sb, res);
        return res;
    }
    public void letterCombinationsRecur(String digits, int num, StringBuilder sb, List<String> res) {
        if (num == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(num) - '2');
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            letterCombinationsRecur(digits, num+1, sb, res);
            sb.deleteCharAt(num);
        }
    }
}

//3/21/2015 --> iteration
//pay attention to how to handle to base case. need to add "" as a seed. 
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<String>();
        if (digits.equals("")) {
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> newRes = new ArrayList<String>();
            String letters = map.get(digits.charAt(i));
            for (int j = 0; j < letters.length(); j++) {
                char toAdd = letters.charAt(j);
                for (String s : res) {
                    newRes.add(s + toAdd);
                }
            }
            res = newRes;
        }
        return res;
    }
}
