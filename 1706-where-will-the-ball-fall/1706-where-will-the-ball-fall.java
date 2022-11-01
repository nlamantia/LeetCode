class Solution {
    // O(m * n) time | O(m + n) space
    public int[] findBall(int[][] grid) {
        int[] answer = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            answer[i] = dfs(grid, 0, i);
        }
        return answer;
    }
    
    private int dfs(int[][] grid, int row, int col) {
        if (row == grid.length) {
            return col;
        }
        
        int dc = grid[row][col];
        if (col + dc == -1 || col + dc == grid[0].length || grid[row][col + dc] != grid[row][col]) {
            return -1;
        }
        
        return dfs(grid, row + 1, col + dc);
    }
}