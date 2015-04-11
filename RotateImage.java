public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int i = 0;
        int j = n - 1;
        while (i < j) {
            for (int k = i; k < j; k++) {
                rotatePoints(i, k, matrix, n);
            }
            i++;
            j--;
        }
    }
    public void rotatePoints(int i, int j, int[][] matrix, int n) {
        int tmp = matrix[n-1-j][i];
        matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
        matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
        matrix[j][n-1-i] = matrix[i][j];
        matrix[i][j] = tmp;
    }
}
