class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        int start = 0, end = 0, maxLength = 0;
        while (end < s.length()) {
            char endChar = s.charAt(end);
            counts.put(endChar, counts.getOrDefault(endChar, 0) + 1);
            
            while (counts.get(endChar) > 1) {
                char startChar = s.charAt(start++);
                counts.put(startChar, counts.get(startChar) - 1);
            }
            
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}