//bit manipulation!
//ref: https://github.com/leetcoders/LeetCode/blob/master/N-QueensII.h
public class Solution {
    public List<String[]> solveNQueens(int n) {
        boolean[] usedCol = new boolean[n];
        boolean[] usedDiagSum = new boolean[2*n-1];
        boolean[] usedDiagDiff = new boolean[2*n-1];
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<String[]> res = new ArrayList<String[]>();
        _solveNQueens(n, 0, usedCol, usedDiagSum, usedDiagDiff, board, res);
        return res;
    }
    public void _solveNQueens(int n, int i, boolean[] usedCol, 
      boolean[] usedDiagSum, boolean[] usedDiagDiff, char[][] board, List<String[]> res) {
        if (n == i) {
            String[] newRes = new String[n];
            for (int k = 0; k < n; k++) {
                newRes[k] = new String(board[k]);
            }
            res.add(newRes);
            return;
        } else {
            for (int j = 0; j < n; j++) {
                if (!usedCol[j] && !usedDiagSum[i+j] && !usedDiagDiff[i-j+n-1]) {
                    board[i][j] = 'Q';
                    usedCol[j] = true;
                    usedDiagSum[i+j] = true;
                    usedDiagDiff[i-j+n-1] = true;
                    _solveNQueens(n, i+1, usedCol, usedDiagSum, usedDiagDiff, board, res);
                    board[i][j] = '.';
                    usedCol[j] = false;
                    usedDiagSum[i+j] = false;
                    usedDiagDiff[i-j+n-1] = false;
                }
            }
            return;
        } 
    }
}
