class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        boolean oddCountFound = false;
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            int count = entry.getValue();
            oddCountFound = oddCountFound || (count % 2 != 0);
            if (count % 2 == 0) {
                length += count;
            } else {
                length += (count - 1);
            }
        }
        return oddCountFound ? length + 1 : length;
    }
}