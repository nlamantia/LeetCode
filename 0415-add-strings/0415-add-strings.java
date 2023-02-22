class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int digitSum = carry + digit1 + digit2;
            sum.insert(0, digitSum % 10);
            carry = digitSum / 10;
        }
        
        if (carry > 0) {
            sum.insert(0, carry);
        }
        
        return sum.toString();
    }
}