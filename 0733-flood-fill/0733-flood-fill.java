class Solution {
    // each element in the format [dr, dc]
    private static final int[][] DIRECTIONS = new int[][] {
        new int[] { 0, 1 },
        new int[] { 0, -1 },
        new int[] { 1, 0 },
        new int[] { -1, 0 }
    };
    
    private int originalColor;
    private int newColor;
    private Map<Integer, Set<Integer>> visited;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        originalColor = image[sr][sc];
        newColor = color;
        visited = new HashMap<>();
        dfs(image, sr, sc);
        return image;
    }
    
    private void dfs(int[][] image, int row, int col) {
        if (isOutOfBounds(image, row, col) || isVisited(row, col) || image[row][col] != originalColor) {
            return;
        }
        
        visit(row, col);
        image[row][col] = newColor;
        
        for (int[] direction : DIRECTIONS) {
            dfs(image, row + direction[0], col + direction[1]);
        }
    }
    
    private void visit(int row, int col) {
        if (!visited.containsKey(row)) {
            visited.put(row, new HashSet<>());
        }
        visited.get(row).add(col);
    }
    
    private boolean isVisited(int row, int col) {
        return visited.containsKey(row) && visited.get(row).contains(col);
    }
    
    private boolean isOutOfBounds(int[][] image, int row, int col) {
        return row < 0 || row >= image.length || col < 0 || col >= image[0].length;
    }
}