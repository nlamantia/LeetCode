class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int digit1 = digit(a, i);
            int digit2 = digit(b, j);
            result.insert(0, carry ^ digit1 ^ digit2);
            carry = (carry & digit1) | (digit1 & digit2) | (carry & digit2);
        }
        
        if (carry == 1) {
            result.insert(0, 1);
        }
        
        return result.toString();
    }
    
    private int digit(String s, int i) {
        return i >= 0 && s.charAt(i) == '1' ? 1 : 0;
    }
}