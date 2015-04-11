//majority voting algorithm
public class Solution {
    public int majorityElement(int[] num) {
        int count = 0;
        int currentCandidate = 0;
        for (int i = 0; i < num.length; i++) {
            if (count == 0) {
                count++;
                currentCandidate = num[i];
            } else {
                if (currentCandidate == num[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return currentCandidate;
    }
}
