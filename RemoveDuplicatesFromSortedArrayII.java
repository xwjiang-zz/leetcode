public class Solution {
    public int removeDuplicates(int[] A) {
        int i = 0;
        int j = 0;
        for (; j < A.length; j++ ) {
            if ((i < 2) || A[j] != A[i-2]) {
                A[i++] = A[j];
            }
        }
        return i;
    }
}
