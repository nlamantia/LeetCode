class Solution {
    public int myAtoi(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == s.length()) return 0;
        
        boolean positive = true;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            positive = s.charAt(i) == '+';
            i++;
        }
        
        if (i == s.length()) return 0;
        
        int num = 0;
        while (i < s.length() && isNumeric(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (positive && num > (Integer.MAX_VALUE - digit) / 10) {
                return Integer.MAX_VALUE;
            } else if (!positive && -num < (Integer.MIN_VALUE + digit) / 10) {
                return Integer.MIN_VALUE;
            } else {
                num = (num * 10) + digit;
            }
            i++;
        }
        
        return positive ? num : -num;
    }
    
    private boolean isNumeric(char c) {
        return (c - '9') <= 0 && (c - '0') >= 0;
    }
}