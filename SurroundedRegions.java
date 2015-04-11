//1st Solution: no AC with large data set: stack overflow error
//2nd Solution: better logic but still no AC with large data set: stack overflow error
//for 2nd Solution no need to have visited in DFS recursion. Use orignal board to record positions that should be changed to 'X'
//the same thought goes to SetZeros
//3rd Solution: used BFS -->finally AC.
public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        Set<Integer> toFill = new HashSet<Integer>();
        boolean[][] visited = new boolean[m][n];
        normalDFS(board, 0, 0, visited, toFill);
        for (Integer each : toFill) {
            int i = each/n;
            int j = each%n;
            board[i][j] = 'X';
        }
    }
    public void normalDFS(char[][] board, int i, int j, boolean[][] visited, Set<Integer> toFill) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (board[i][j] == 'X') {
            visited[i][j] = true;
        } else {
            Set<Integer> checking = new HashSet<Integer>();
            if (checkDFS(board, i, j, visited, checking)) {
                toFill.addAll(checking);
            }
        }
        normalDFS(board, i+1, j, visited, toFill);
        normalDFS(board, i-1, j, visited, toFill);
        normalDFS(board, i, j+1, visited, toFill);
        normalDFS(board, i, j-1, visited, toFill);
    }
    public boolean checkDFS(char[][] board, int i, int j, boolean[][] visited, Set<Integer> checking) {
        int m = board.length;
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (visited[i][j]) {
            return true;
        }
        if (board[i][j] == 'X') {
            return true;
        } else {
            checking.add(i*n+j);
            visited[i][j] = true;
            return checkDFS(board, i+1, j, visited, checking) && checkDFS(board, i-1, j, visited, checking) && checkDFS(board, i, j+1, visited, checking) && checkDFS(board, i, j-1, visited, checking);
        }
    }
}

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) {
            return;
        }
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(board, visited, i, 0, m, n);
            dfs(board, visited, i, n-1, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, visited, 0, j, m, n);
            dfs(board, visited, m-1, j, m ,n);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'V' ? 'X' : 'O';
            }
        }
    }
    public void dfs(char[][] board, boolean[][] visited, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'V';
        visited[i][j] = true;
        dfs(board, visited, i+1, j, m, n);
        dfs(board, visited, i-1, j, m, n);
        dfs(board, visited, i, j+1, m, n);
        dfs(board, visited, i, j-1, m, n);
    }
}
