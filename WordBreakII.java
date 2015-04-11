//use the same trick as in WordLadderII. use map to remember from where to jump to the current place and then use backtracking
public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        int n = s.length();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);
        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            for (int j = front + 1; j < n + 1; j++) {
                if (dict.contains(s.substring(front, j))) {
                    if (!map.containsKey(j)) {
                        map.put(j, new ArrayList<Integer>());
                        queue.add(j);
                    }
                    map.get(j).add(front);
                }
            }
        }
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        if (!map.containsKey(n)) {
            return res;
        }
        backTrack(map, s, sb, res, n);
        return res;
    }
    public void backTrack(Map<Integer, List<Integer>> map, String s, StringBuilder sb, List<String> res, int n) {
        if (n == 0) {
            sb.deleteCharAt(0);
            res.add(sb.toString());
            sb.insert(0, " ");
            return;
        }
        for (Integer i : map.get(n)) {
            sb.insert(0, s.substring(i, n));
            sb.insert(0, " ");
            backTrack(map, s, sb, res, i);
            sb.delete(0, 1 + n - i);
        }
    }
}
