//compare with JumpGameII
//although this is more concise that last time, there is another one much better
public class Solution {
    public boolean canJump(int[] A) {
        int lastBorder = -1;
        int currentBorder = 0;
        while (lastBorder < currentBorder && currentBorder < A.length) {
            int nextBorder = currentBorder;
            for (int i = lastBorder + 1; i <= currentBorder; i++) {
                nextBorder = Math.max(nextBorder, i + A[i]);
            }
            lastBorder = currentBorder;
            currentBorder = nextBorder;
        }
        return currentBorder >= A.length - 1;
    }
}

//better solution
public class Solution {
    public boolean canJump(int[] A) {
        int i = 0;
        int j = 0;
        int n = A.length;
        while (i <= j && j < n) {
            j = Math.max(j, i+A[i]);
            i++;
        }
        return j >= n-1;
    }
}
