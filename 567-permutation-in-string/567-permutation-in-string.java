// Complexity analysis - let m be the length of s1 and n be the length of s2
class Solution {
    // O(n * m) time | O(1)
    public boolean checkInclusion(String s1, String s2) {
        // O(m) time
        int[] s1Counts = new int['z' - 'a' + 1];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
        }
        
        // O(n * m) time
        int start = 0, end = 0;
        int[] s2Counts = new int['z' - 'a' + 1];
        while (end < s2.length()) {
            s2Counts[s2.charAt(end) - 'a']++;
            while (end - start + 1 > s1.length()) {
                s2Counts[s2.charAt(start++) - 'a']--;
            }
            if (isPermutation(s1, s1Counts, s2Counts)) {
                return true;
            }
            end++;
        }
        return false;
    }
    
    // O(m) time | O(1) space
    private boolean isPermutation(String s1, int[] s1Counts, int[] s2Counts) {
        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            if (s1Counts[index] != s2Counts[index]) {
                return false;
            }
        }
        return true;
    }
}