class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
        new int[] { 1, 0 },
        new int[] { -1, 0 },
        new int[] { 0, 1 },
        new int[] { 0, -1 }
    };
    
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        if (isOutOfBounds(grid, r, c) || grid[r][c] == '0') {
            return;
        }
        
        grid[r][c] = '0';
        
        for (int[] dir : DIRECTIONS) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
    
    private boolean isOutOfBounds(char[][] grid, int r, int c) {
        return r < 0 || r >= grid.length || c < 0 || c >= grid[0].length;
    }
}