public class Solution {
    public int removeElement(int[] A, int elem) {
        int i, j;
        for (i = 0, j = 0; j < A.length; j++) {
            if (A[j] != elem) {
                A[i++] = A[j];
            }
        }
        return i;
    }
}
