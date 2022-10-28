class Solution {
    // O(n) time | O(1) space
    public char repeatedCharacter(String s) {
        int[] charCounts = new int[26];
        int i;
        for (i = 0; i < s.length() && charCounts[s.charAt(i) - 'a'] == 0; i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        return s.charAt(i);
    }
}