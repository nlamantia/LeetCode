class Solution {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;
        
        int len = 0;
        for (int i = end; i >= 0 && s.charAt(i) != ' '; i--) {
            len++;
        }
        return len;
    }
}