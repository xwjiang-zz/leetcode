public class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        return _findMedianSortedArrays(A, B, 0, A.length - 1, 0, B.length - 1);
    }
    public double _findMedianSortedArrays(int[] A, int[] B, int ai, int aj, int bi, int bj) {
        int alen = aj - ai + 1;
        int blen = bj - bi + 1;
        if (alen > blen) {
            return _findMedianSortedArrays(B, A, bi, bj, ai, aj);
        }
        if (alen < 3) {
            if (blen < 3) {
                int[] tmp = new int[alen + blen];
                for (int i = 0; i < alen; i++) {
                    tmp[i] = A[ai + i];
                }
                for (int i = 0; i < blen; i++) {
                    tmp[alen + i] = B[bi + i];
                }
                Arrays.sort(tmp);
                return findSingleArrayMedian(tmp, 0, alen + blen - 1);
            }
            if (blen % 2 == 0) {
                int[] tmp = new int[4 + alen];
                for (int i = 0; i < alen; i++) {
                    tmp[i] = A[ai + i];
                }
                for (int i = 0; i < 4; i++) {
                    tmp[alen + i] = B[(bi + bj)/2 - 1 + i];
                }
                Arrays.sort(tmp);
                return findSingleArrayMedian(tmp, 0, alen + 3);
            } else {
                int[] tmp = new int[3 + alen];
                for (int i = 0; i < alen; i++) {
                    tmp[i] = A[ai + i];
                }
                for (int i = 0; i < 3; i++) {
                    tmp[alen + i] = B[(bi + bj)/2 - 1 + i];
                }
                Arrays.sort(tmp);
                return findSingleArrayMedian(tmp, 0, alen + 2);
            }
        } else {
            double am = findSingleArrayMedian(A, ai, aj);
            double bm = findSingleArrayMedian(B, bi, bj);
            if (am == bm) {
                return am;
            } else {
                int cut = Math.min((aj - ai)/2, (bj - bi)/2);
                if (am < bm) {
                    return _findMedianSortedArrays(A, B, ai + cut, aj, bi, bj - cut);
                } else {
                    return _findMedianSortedArrays(A, B, ai, aj - cut, bi + cut, bj);
                }
            }
        }
    }
    public double findSingleArrayMedian(int[] A, int i, int j) {
        if ((j - i + 1) % 2 == 0) {
            return (A[(i + j) / 2] + A[(i + j) / 2 + 1]) / 2.0;
        } else {
            return A[(i + j) / 2];
        }
    }
}
