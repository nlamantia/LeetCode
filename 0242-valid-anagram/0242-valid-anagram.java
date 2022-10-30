class Solution {
    private static final int ALPHABET_SIZE = 26;
    
    // O(s + t) time | O(1) space
    public boolean isAnagram(String s, String t) {
        int[] charCounts = new int[ALPHABET_SIZE];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        
        for (char c : t.toCharArray()) {
            charCounts[c - 'a']--;
        }
        
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (charCounts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}