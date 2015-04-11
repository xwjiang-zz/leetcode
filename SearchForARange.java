public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        int i = getLowerBound(A, target);
        int j = getHigherBound(A, target);
        if (i <= j) {
            res[0] = i;
            res[1] = j;
        } else {
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
    public int getLowerBound(int[] A, int target) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (A[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
    public int getHigherBound(int[] A, int target) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int mid = (i + j)/2;
            if (target < A[mid]) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return j;
    }
}
