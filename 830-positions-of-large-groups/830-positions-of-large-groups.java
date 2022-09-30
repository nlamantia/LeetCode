class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> groups = new LinkedList<>();
        if (s == null || s.length() < 3) return groups;
        
        int rangeStart = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (i - rangeStart >= 3) {
                    groups.add(Arrays.asList(rangeStart, i - 1));
                }
                rangeStart = i;
            }
        }
        
        if (s.length() - rangeStart >= 3) {
            groups.add(Arrays.asList(rangeStart, s.length() - 1));
        }
        
        return groups;
    }
}