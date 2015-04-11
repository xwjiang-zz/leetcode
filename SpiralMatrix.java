public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<Integer>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return res;
        }
        int i1 = 0;
        int i2 = m-1;
        int j1 = 0;
        int j2 = n-1;
        while (true) {
            for (int j = j1; j <= j2; j++) {
                res.add(matrix[i1][j]);
            }
            i1++;
            if (i1 > i2) {
                break;
            }
            for (int i = i1; i <= i2; i++) {
                res.add(matrix[i][j2]);
            }
            j2--;
            if (j1 > j2) {
                break;
            }
            for (int j = j2; j >= j1; j--) {
                res.add(matrix[i2][j]);
            }
            i2--;
            if (i1 > i2) {
                break;
            }
            for (int i = i2; i >= i1; i--) {
                res.add(matrix[i][j1]);
            }
            j1++;
            if (j1 > j2) {
                break;
            }
        }
        return res;
    }
}
