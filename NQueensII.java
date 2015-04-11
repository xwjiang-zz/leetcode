//iteration method!
public class Solution {
    public int totalNQueens(int n) {
        int res = 0;
        int[] path = new int[n];
        int row = 0;
        for (int i = 0; i < n; i++) {
            path[i] = -1;
        }
        while(row >= 0) {
            if (row == n) {
                res++;
                row--;
            } else {
                int col = path[row] + 1;
                for (; col < n; col++) {
                    if (valid(path, row, col)) {
                        path[row++] = col;
                        break;
                    }
                }
                if (col == n) {
                    path[row--] = -1;
                }
            }
        }
        return res;
    }
    public boolean valid(int[] path, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (path[i] == col || path[i] + i == col + row || path[i] - i == col - row) {
                return false;
            }
        }
        return true;
    }
}
