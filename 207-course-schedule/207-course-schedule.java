class Solution {
    private Map<Integer, Set<Integer>> adj;
    private Set<Integer> visited;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new HashSet<>();
        adj = buildAdjacencyList(prerequisites);
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int current, Set<Integer> currentPath) {
        if (currentPath.contains(current)) {
            return false;
        }
        
        if (visited.contains(current)) {
            return true;
        }
        
        currentPath.add(current);
        for (int pre : adj.getOrDefault(current, Collections.emptySet())) {
            if (!dfs(pre, currentPath)) {
                return false;
            }
        }
        currentPath.remove(current);
        visited.add(current);
        return true;
    }
    
    private Map<Integer, Set<Integer>> buildAdjacencyList(int[][] prerequisites) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int[] prereq : prerequisites) {
            if (!result.containsKey(prereq[0])) {
                result.put(prereq[0], new HashSet<>());
            }
            result.get(prereq[0]).add(prereq[1]);
        }
        return result;
    }
}