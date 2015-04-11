//map O(1)

public class Solution {
    public int longestConsecutive(int[] num) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], 0);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = (int)entry.getKey();
            int value = (int)entry.getValue();
            if (value != 0) {
                continue;
            }
            while (map.containsKey(++key)) {}
            int count = 0;
            while (map.containsKey(--key)) {
                map.put(key, ++count);
            }
            res = Math.max(res, count);
        }
        return res;
    }
}
