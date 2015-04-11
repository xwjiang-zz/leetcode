//traverse three times along different directions
//another way is to traverse only one time using bit manipulation
//notice the precedency between & and ==/!=
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                used[j] = false;
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (used[board[i][j]-'1']) {
                    return false;
                }
                used[board[i][j]-'1'] = true;
            }
        }
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                used[i] = false;
            }
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (used[board[i][j]-'1']) {
                    return false;
                }
                used[board[i][j]-'1'] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 9; k++) {
                    used[k] = false;
                }
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (board[3*i+m][3*j+n] == '.') {
                            continue;
                        }
                        if (used[board[3*i+m][3*j+n]-'1']) {
                            return false;
                        }
                        used[board[3*i+m][3*j+n]-'1'] = true;
                    }
                }
            }
        }
        return true;
    }
}

//bit manipulation
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = 0;
        int[] col = new int[9];
        int[] box = new int[9];
        for (int i = 0; i < 9; i++) {
            col[i] = 0;
            box[i] = 0;
        }
        for (int i = 0; i < 9; i++) {
            row = 0;
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int boxIndex = (i/3)*3 + j/3;
                int bit = 1 << board[i][j];
                if ((row & bit) != 0 || (col[j] & bit) != 0 || (box[boxIndex] & bit) != 0) {
                    return false;
                }
                row |= bit;
                col[j] |= bit;
                box[boxIndex] |= bit;
            }
        }
        return true;
    }
}
