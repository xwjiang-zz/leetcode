/*
1. bucket sort
2. buckSize cannot be zero.
*/
public class Solution {
    public class Pair {
        int first;
        int second;
        Pair() {
            this.first = -1;
            this.second = -1;
        }
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int maximumGap(int[] num) {
        if (num.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
        }
        int buckSize = Math.max((max-min)/(num.length-1), 1);
        Pair[] buckArray = new Pair[(max-min)/buckSize + 1];
        for (int i = 0; i < buckArray.length; i++) {
            buckArray[i] = new Pair();
        }
        for (int i = 0; i < num.length; i++) {
            int key = (num[i] - min)/buckSize;
            if (buckArray[key].first == -1) {
                buckArray[key].first = num[i];
                buckArray[key].second = num[i];
            } else {
                buckArray[key].first = Math.min(buckArray[key].first, num[i]);
                buckArray[key].second = Math.max(buckArray[key].second, num[i]);
            }
        }
        int maxGap = 0;
        int last = buckArray[0].second;
        for (int i = 1; i < buckArray.length; i++) {
            if (buckArray[i].first != -1) {
                maxGap = Math.max(maxGap, buckArray[i].first - last);
                last = buckArray[i].second;
            }
        }
        return maxGap;
    }
}
