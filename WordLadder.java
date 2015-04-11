//very length

//2nd Solution here: ref : https://github.com/leetcoders/LeetCode/blob/master/WordLadder.h
//complexity: len*n*26
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();
        populateInterMap(dict, map);
        populateGraph(map, graph);
        return bfs(start, end, graph);
    }
    public void populateInterMap(Set<String> dict, HashMap<String, ArrayList<String>> map) {
        for (String s : dict) {
            int len = s.length();
            char[] ss = s.toCharArray();
            for (int k = 0; k < len; k++) {
                char tmp = ss[k];
                ss[k] = '*';
                String newString = String.valueOf(ss);
                if (!map.containsKey(newString)) {
                    map.put(newString, new ArrayList<String>());
                }
                map.get(newString).add(s);
                ss[k] = tmp;
            }
        }
    }
    public void populateGraph(HashMap<String, ArrayList<String>> map, HashMap<String, ArrayList<String>> graph) {
        for (ArrayList<String> list : map.values()) {
            for (int i = 0; i < list.size(); i++) {
                if (!graph.containsKey(list.get(i))) {
                    graph.put(list.get(i), new ArrayList<String>());
                }
                for (int j = 0; j < list.size(); j++) {
                    if (j == i) {
                        continue;
                    } else {
                        graph.get(list.get(i)).add(list.get(j));
                    }
                }
            }
        }
    }
    public int bfs(String start, String end, HashMap<String, ArrayList<String>> graph) {
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.add(start);
        queue.add("");
        int count = 1;
        while (queue.size() > 1) {
            String front = queue.poll();
            if (front == "") {
                count++;
                queue.add("");
            } else {
                visited.add(front);
                if (front.equals(end)) {
                    return count;
                } else {
                    for (String s : graph.get(front)) {
                        if (!visited.contains(s)) {
                            queue.add(s);
                        }
                    }
                }
            }
        }
        return 0;
    }
}

//2nd
public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        if (start.equals(end)) {
            return 1;
        }
        queue.add(start);
        visited.add(start);
        queue.add("");
        int count = 1;
        while (queue.size() > 1) {
            String front = queue.poll();
            if (front == "") {
                count++;
                queue.add("");
            } else {
                char[] front1 = front.toCharArray();
                for (int i = 0; i < front.length(); i++) {
                    char before = front1[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        front1[i] = c;
                        if (String.valueOf(front1).equals(end)) {
                            return count+1;
                        }
                        if (dict.contains(String.valueOf(front1)) && !visited.contains(String.valueOf(front1))) {
                            queue.add(String.valueOf(front1));
                            visited.add(String.valueOf(front1));
                        }
                        front1[i] = before;
                    }
                }
            }
        }
        return 0;
    }
}
