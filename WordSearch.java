//where to judge whether row and col is withinn the boundary --> better judge it in the recursive function
//also where is the final return point --> when index == word.length()
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_exist(board, used, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean _exist(char[][] board, boolean[][] used, int row, int col, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }
        if (used[row][col]) {
            return false;
        }
        if (board[row][col] == word.charAt(index)) {
            used[row][col] = true;
            if (_exist(board, used, row-1, col, word, index+1)) {
                return true;
            }
            if (_exist(board, used, row+1, col, word, index+1)) {
                return true;
            }
            if (_exist(board, used, row, col-1, word, index+1)) {
                return true;
            }
            if (_exist(board, used, row, col+1, word, index+1)) {
                return true;
            }
            used[row][col] = false;
            return false;
        }
        return false;
    }
}

//3/31/2015
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (existRec(board, word, 0, i, j, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean existRec(char[][] board, String word, int toComp, int i, int j, int m, int n) {
        if (toComp == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (word.charAt(toComp) != board[i][j]) {
            return false;
        }
        board[i][j] = '*';
        if (existRec(board, word, toComp+1, i+1, j, m, n) ||
            existRec(board, word, toComp+1, i-1, j, m, n) ||
            existRec(board, word, toComp+1, i, j+1, m, n) ||
            existRec(board, word, toComp+1, i, j-1, m, n)) {
                return true;
        } else {
            board[i][j] = word.charAt(toComp);
            return false;
        }
    }
}
