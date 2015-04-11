//same as I
public class Solution {
    public int[][] generateMatrix(int n) {
        int i1 = 0;
        int i2 = n-1;
        int j1 = 0;
        int j2 = n-1;
        int count = 1;
        int[][] matrix = new int[n][n];
        while (i1 <= i2 && j1 <= j2) {
            for (int j = j1; j <= j2; j++) {
                matrix[i1][j] = count++;
            }
            i1++;
            if (i1 > i2) {
                break;
            }
            for (int i = i1; i <= i2; i++) {
                matrix[i][j2] = count++;
            }
            j2--;
            if (j1 > j2) {
                break;
            }
            for (int j = j2; j >= j1; j--) {
                matrix[i2][j] = count++;
            }
            i2--;
            if (i1 > i2) {
                break;
            }
            for (int i = i2; i >= i1; i--) {
                matrix[i][j1] = count++;
            }
            j1++;
            if (j1 > j2) {
                break;
            }
        }
        return matrix;
    }
}

//3/29/2015
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            for (int k = i; k < j; k++) {
                res[i][k] = ++count;
            }
            for (int k = i; k < j; k++) {
                res[k][j] = ++count;
            }
            for (int k = j; k > i; k--) {
                res[j][k] = ++count;
            }
            for (int k = j; k > i; k--) {
                res[k][i] = ++count;
            }
            i++;
            j--;
        }
        if (i == j) {
            res[i][i] = ++count;
        }
        return res;
    }
}
