class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[m - 1][n - 1] = 1;
        
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                grid[row][col] += numPaths(grid, row + 1, col) + numPaths(grid, row, col + 1);
            }
        }
        
        return grid[0][0];
    }
    
    private int numPaths(int[][] grid, int row, int col) {
        return (row < grid.length && col < grid[0].length) ? grid[row][col] : 0;
    }
}