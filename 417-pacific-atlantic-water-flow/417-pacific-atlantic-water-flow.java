class Solution {
    private static final int[][] DIRECTIONS = new int[][] {
        new int[] { 0, 1 },
        new int[] { 0, -1 },
        new int[] { 1, 0 },
        new int[] { -1, 0 }
    };
    
    private int[][] grid;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights.length == 0) return res;
        
        grid = heights;
        Set<List<Integer>> flowsToAtlantic = new HashSet<>();
        Set<List<Integer>> flowsToPacific = new HashSet<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (bordersAtlantic(r, c)) 
                    dfs(r, c, 0, flowsToAtlantic);
                
                if (bordersPacific(r, c)) 
                    dfs(r, c, 0, flowsToPacific);
            }
        }
        
        for (List<Integer> coord : flowsToAtlantic) {
            if (flowsToPacific.contains(coord)) {
                res.add(coord);
            }
        }
        return res;
    }
    
    private void dfs(int r, int c, int prev, Set<List<Integer>> flowsToOcean) {
        if (isInOcean(r, c) || flowsToOcean.contains(Arrays.asList(r, c)) || grid[r][c] < prev) {
            return;
        }
        flowsToOcean.add(Arrays.asList(r, c));
        
        for (int[] direction : DIRECTIONS) {
            int dr = direction[0], dc = direction[1];
            dfs(r + dr, c + dc, grid[r][c], flowsToOcean);
        } 
    }
    
    private boolean isInOcean(int r, int c) {
        return r < 0 || r >= grid.length || c < 0 || c >= grid[0].length;
    }
    
    private boolean bordersPacific(int r, int c) {
        return r == 0 || c == 0;
    }
    
    private boolean bordersAtlantic(int r, int c) {
        return r == grid.length - 1 || c == grid[0].length - 1;
    }
}