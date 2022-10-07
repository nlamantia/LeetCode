class Solution {
    // O(n) time | O(1) space
    public int minimumLength(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)) {
            // advance along prefix
            char c = s.charAt(start);
            start++;
            while (start < end && s.charAt(start) == c) {
                start++;
            }
            
            // advance along prefix
            end--;
            while (end >= start && s.charAt(end) == c) {
                end--;
            }
        }
        
        return end < start ? 0 : (end - start + 1);
    }
}