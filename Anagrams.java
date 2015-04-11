//map key cannot be char array, use string instead!

public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String s = new String(a);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(strs[i]);
        }
        List<String> res = new ArrayList<String>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                res.addAll(list);
            }
        }
        return res;
    }
}
