//how to make use of String[] L --> convert it to a hashmap
//build another hashmap to store the already encountered elements
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        int len = L[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }
        for (int i = 0; i < len; i++) {
            Map<String, Integer> left = new HashMap<String, Integer>(map);
            int count = 0;
            int j = i;
            int k = i;
            while (k + len <= S.length()) {
                String s = S.substring(k, k+len);
                if (!left.containsKey(s)) {
                    left = new HashMap<String, Integer>(map);
                    count = 0;
                    k += len;
                    j = k;
                } else if (left.get(s) > 0) {
                    left.put(s, left.get(s) - 1);
                    count++;
                    if (count == L.length) {
                        res.add(j);
                    }
                    k += len;
                } else {
                    s = S.substring(j, j+len);
                    left.put(s, left.get(s)+1);
                    count--;
                    j += len;
                }
            }
        }
        return res;
    }
}

//3/30/2015
//After I did minimum window substring, I further wanted to explore the similarities and differences between this problem and that one
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i])+1);
            } else {
                map.put(L[i], 1);
            }
        }
        Map<String, Integer> toMatch = new HashMap<String, Integer>(map);
        int len = L[0].length();
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < len; i++) {
            int j = i;
            int k = i;
            int countToMatch = L.length;
            toMatch = new HashMap<String, Integer>(map);
            while (k + len <= S.length()) {
                String kStr = S.substring(k, k + len);
                if (!toMatch.containsKey(kStr)) {
                    countToMatch = L.length;
                    toMatch = new HashMap<String, Integer>(map);
                    j = k + len;
                    k = j;
                } else if (toMatch.get(kStr) > 0) {
                    countToMatch--;
                    toMatch.put(kStr, toMatch.get(kStr) - 1);
                    k = k + len;
                } else {
                    String jStr = S.substring(j, j + len);
                    toMatch.put(jStr, toMatch.get(jStr) + 1);
                    countToMatch++;
                    j = j + len;
                }
                if (countToMatch == 0) {
                    res.add(j);
                }
            }
        }
        return res;
    }
}
