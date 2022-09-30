class Solution {
    private Map<Integer, Set<Integer>> adj;
    private int[] nums;
    
    // O(n) time | O(n) space
    public int[] restoreArray(int[][] adjacentPairs) {
        // build adjacency map
        adj = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            addAdjacentNumbers(pair[0], pair[1]);
            addAdjacentNumbers(pair[1], pair[0]);
        }
        
        // dfs from first node we find that has only 1 neighbor
        nums = new int[adjacentPairs.length + 1];
        for (Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()) {
            if (entry.getValue().size() == 1) {
                dfs(entry.getKey(), 0, new HashSet<>());
            }
        }
        adj = null;
        
        return nums;
    }
    
    private void dfs(int current, int nextIndex, Set<Integer> visited) {
        if (visited.contains(current)) {
            return;
        }
        
        visited.add(current);
        nums[nextIndex] = current;
        
        for (Integer neighbor : adj.get(current)) {
            dfs(neighbor, nextIndex + 1, visited);
        }
    }
    
    private void addAdjacentNumbers(int src, int dest) {
        Set<Integer> neighbors = adj.getOrDefault(src, new HashSet<>());
        neighbors.add(dest);
        adj.put(src, neighbors);
    }
}