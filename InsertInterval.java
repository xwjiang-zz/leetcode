//List uses add not insert
//List uses remove not delete! 
//notice when iterating the list and deleting its element at the same time, use while and not always i++
//use divide and conquer --> look at it together with "search for a range" and "search for insertion point"
//pay attention to the condition that "intervals" are non overlapping!
//interval tree! http://www.geeksforgeeks.org/interval-tree/

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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int start = newInterval.start;
        int end = newInterval.end;
        boolean added = false;
        int i = 0;
        while (i < intervals.size()) {
            Interval interval = intervals.get(i);
            if (interval.end >= start && interval.start <= end) {
                start = Math.min(start, interval.start);
                end = Math.max(end, interval.end);
                intervals.remove(i);
            } else if (interval.end < start) {
                i++;
            } else {
                intervals.add(i, new Interval(start, end));
                added = true;
                break;
            }
        }
        if (!added) {
            intervals.add(i, new Interval(start, end));
        }
        return intervals;
    }
}

//divide and conquer

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int l = getLowerBound(intervals, newInterval);
        int u = getUpperBound(intervals, newInterval);
        if (l > u) {
            intervals.add(l, newInterval);
        } else {
            int start = Math.min(newInterval.start, intervals.get(l).start);
            int end = Math.max(newInterval.end, intervals.get(u).end);
            for (int i = l; i <= u; i++) {
                intervals.remove(l);
            }
            intervals.add(l, new Interval(start, end));
        }
        return intervals;
    }
    public int getLowerBound(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        int j = intervals.size()-1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (intervals.get(mid).end < newInterval.start) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
    public int getUpperBound(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        int j = intervals.size()-1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (intervals.get(mid).start > newInterval.end) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
}

//3/29/2015
//intervals.subList(low, up).clear();
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        int j = intervals.size()-1;
        while (i <= j) {
            int m = (i + j)/2;
            if (intervals.get(m).end >= newInterval.start) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        int low = i;
        i = 0;
        j = intervals.size()-1;
        while (i <= j) {
            int m = (i+j)/2;
            if (intervals.get(m).start <= newInterval.end) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int up = i;
        int start = newInterval.start;
        int end = newInterval.end;
        if (low < up) {
            start = Math.min(start, intervals.get(low).start);
            end = Math.max(end, intervals.get(up-1).end);
            intervals.subList(low, up).clear();
        }
        intervals.add(low, new Interval(start, end));
        return intervals;
    }
}
