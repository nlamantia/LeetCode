class Solution {
    // O(n) time | O(1) space
    public int numDecodings(String s) {
        int current = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        int next = 1;
        
        for (int i = s.length() - 2; i >= 0; i--) {
            int temp = current;
            if (s.charAt(i) == '0') {
                current = 0;
            } else if (canBeDoubleDigit(s, i)) {
                current += next;
            }
            
            next = temp;
        }
        
        return current;
    }
    
    private boolean canBeDoubleDigit(String s, int i) {
        return s.charAt(i) == '1' || (s.charAt(i) == '2' && ((int) (s.charAt(i + 1) - '6')) <= 0);
    }
}