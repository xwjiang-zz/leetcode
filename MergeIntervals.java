//java comparator and java comparable: http://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                if (a.start < b.start) {
                    return -1;
                } else if (a.start > b.start) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > end) {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            } else {
                end = Math.max(end, intervals.get(i).end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
