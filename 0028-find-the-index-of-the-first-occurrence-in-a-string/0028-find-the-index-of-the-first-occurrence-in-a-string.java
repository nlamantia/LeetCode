class Solution {
    public int strStr(String haystack, String needle) {
        int h = 0;
        while (h <= haystack.length() - needle.length()) {
            int n = 0;
            while (n < needle.length() && haystack.charAt(h + n) == needle.charAt(n)) {
                n++;
            }
            
            if (n == needle.length()) {
                return h;
            }
            
            h++;
        }
        return -1;
    }
}