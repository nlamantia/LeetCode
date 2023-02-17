class Solution {
    // O(n) time | O(n) space
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> bad = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                bad.add(fronts[i]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!bad.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
            
            if (!bad.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}