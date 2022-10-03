class Solution {
    public int numDecodings(String s) {
        int[] ways = new int[s.length()];
        if (s.charAt(s.length() - 1) != '0') {
            ways[s.length() - 1] = 1;
        }
        
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } 
            
            ways[i] += ways[i + 1];
            if (canBeDoubleDigit(s, i)) {
                ways[i] += i < s.length() - 2 ? ways[i + 2] : 1;
            }
        }
        
        return ways[0];
    }
    
    private boolean canBeDoubleDigit(String s, int i) {
        return s.charAt(i) == '1' || (s.charAt(i) == '2' && ((int) (s.charAt(i + 1) - '6')) <= 0);
    }
}