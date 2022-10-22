class Solution {
    // O(n) time | O(n) space
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] >= 10 ? 1 : 0;
            digits[i] %= 10;
        }
        
        if (carry == 0) {
            return digits;
        } else {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            return newDigits;
        }
    }
}