public class Solution {
    public int searchInsert(int[] A, int target) {
        int i = 0;
        int j = A.length-1;
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
}
