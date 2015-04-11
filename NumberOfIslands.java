public class Solution {
    public int numIslands(char[][] grid) {
        int num = 0;
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        if (n == 0) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == '0' || c == 'V') {
                    continue;
                }
                travelIsland(grid, i, j, m , n);
                num++;
            }
        }
        return num;
    }
    public void travelIsland(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        char c = grid[i][j];
        if (c == '0' || c == 'V') {
            return;
        }
        grid[i][j] = 'V';
        travelIsland(grid, i+1, j, m, n);
        travelIsland(grid, i-1, j, m, n);
        travelIsland(grid, i, j+1, m, n);
        travelIsland(grid, i, j-1, m, n);
    }
}
