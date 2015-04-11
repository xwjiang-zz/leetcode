//my solution: NG. O(n^3)...
public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    continue;
                }
                int count = 2;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    } else if ((points[i].x - points[j].x) * (points[k].y - points[i].y) 
                    == (points[i].y - points[j].y) * (points[k].x - points[i].x)) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res == 0 ? points.length : res;
    }
}

//another even worse, but learn from the thought how to hash a pair of number: x_y
//notice the difference between HashMap and TreeMap. For TreeMap, no hash function needed for customized class

public class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        Map<String, Integer> slopeMap = new HashMap<String, Integer>();
        for (int i = 0; i < points.length; i++) {
            slopeMap.clear();
            int sp = 0;
            int ss = 0;
            for (int j = 0; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    sp++;
                } else {
                    int x = points[i].x - points[j].x;
                    int y = points[i].y - points[j].y;
                    boolean found = false;
                    for (String s : slopeMap.keySet()) {
                        String[] tokens = s.split("_");
                        int slopeX = Integer.parseInt(tokens[0]);
                        int slopeY = Integer.parseInt(tokens[1]);
                        if (slopeX * y == slopeY * x) {
                            slopeMap.put(s, slopeMap.get(s) + 1);
                            ss = Math.max(ss, slopeMap.get(s));
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        String s = String.valueOf(points[j].x) + "_" + String.valueOf(points[j].y);
                        slopeMap.put(s, 1);
                        ss = Math.max(ss, 1);
                    }
                }
            }
            res = Math.max(res, sp + ss);
        }
        return res;
    }
}
