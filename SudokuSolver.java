public class Solution {
    public void solveSudoku(char[][] board) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < 9; i++) {
            row[i] = 0;
            col[i] = 0;
            box[i] = 0;
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int bit = 1 << (board[i][j] - '1');
                row[i] |= bit;
                col[j] |= bit;
                int boxIndex = i/3*3 + j/3;
                box[boxIndex] |= bit;
            }
        }
        _solveSudoku(board, row, col, box, 0);
    }
    public boolean _solveSudoku(char[][] board, int[] row, int[] col, int[] box, int count) {
        if (count == 81) {
            return true;
        }
        int i = count/9;
        int j = count%9;
        if (board[i][j] != '.') {
            return(_solveSudoku(board, row, col, box, count+1));
        } else {
            for (int shift = 0; shift < 9; shift++) {
                int bit = 1 << shift;
                int boxIndex = i/3*3 + j/3;
                if ((row[i] & bit) == 0 && (col[j] & bit) == 0 && (box[boxIndex] & bit) == 0) {
                    row[i] |= bit;
                    col[j] |= bit;
                    box[boxIndex] |= bit;
                    board[i][j] = (char)(shift + '1');
                    if (_solveSudoku(board, row, col, box, count+1)) {
                        return true;
                    }
                    row[i] &= ~bit;
                    col[j] &= ~bit;
                    box[boxIndex] &= ~bit;
                    board[i][j] = '.';
                }
            }
            return false;
        }
    }
}
