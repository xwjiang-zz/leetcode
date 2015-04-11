public class Solution {
    public int maxProduct(int[] A) {
        int pos = 0;
        int neg = 0;
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                pos = Math.max(A[i], pos*A[i]);
                neg = neg*A[i];
            } else if (A[i] < 0) {
                int tmp = pos;
                pos = neg*A[i];
                neg = Math.min(A[i], tmp*A[i]);
            } else {
                pos = 0;
                neg = 0;
            }
            res = Math.max(res, pos);
        }
        if (res == 0 && A.length == 1) {
            return A[0];
        }
        return res;
    }
}
