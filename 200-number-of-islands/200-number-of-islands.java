class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
        new int[] { 1, 0 },
        new int[] { -1, 0 },
        new int[] { 0, 1 },
        new int[] { 0, -1 }
    };
    
    private Set<List<Integer>> visited;
    
    public int numIslands(char[][] grid) {
        visited = new HashSet<>();
        int islands = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (!visited.contains(Arrays.asList(r, c)) && grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void dfs(char[][] grid, int r, int c) {
        if (isOutOfBounds(grid, r, c) || visited.contains(Arrays.asList(r, c)) || grid[r][c] == '0') {
            return;
        }
        
        visited.add(Arrays.asList(r, c));
        
        for (int[] dir : DIRECTIONS) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
    
    private boolean isOutOfBounds(char[][] grid, int r, int c) {
        return r < 0 || r >= grid.length || c < 0 || c >= grid[0].length;
    }
}