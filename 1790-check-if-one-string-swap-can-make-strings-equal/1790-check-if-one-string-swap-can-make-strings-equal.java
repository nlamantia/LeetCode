class Solution {
    // O(n) time | O(n) space
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() < 2) return s1.equals(s2);
        
        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIndices.add(i);
            }
            
            if (diffIndices.size() > 2) {
                return false;
            }
        }
        
        return isOneSwapAway(s1, s2, diffIndices);
    }
    
    private boolean isOneSwapAway(String s1, String s2, List<Integer> diffIndices) {
        if (diffIndices.isEmpty()) return true;
        
        if (diffIndices.size() == 2) {
            int i1 = diffIndices.get(0), i2 = diffIndices.get(1);
            return s1.charAt(i1) == s2.charAt(i2) && s2.charAt(i1) == s1.charAt(i2);
        }
        
        return false;
    }
}