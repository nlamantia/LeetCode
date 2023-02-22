class Solution {
    private static final String ZERO = "0";
    
    // O(n*(m + n)) time | O(m + n) space
    // m = num digits in num1, n = num digits in num2
    public String multiply(String num1, String num2) {
        if (num1.equals(ZERO) || num2.equals(ZERO)) {
            return ZERO;
        }
        
        String product = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            product = add(product, partialProduct(num1, num2, i));
        }
        
        return product;
    }
    
    private String partialProduct(String num1, String num2, int n2Place) {
        StringBuilder partialProduct = new StringBuilder();
        int d2 = Character.getNumericValue(num2.charAt(n2Place));
        int carry = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int d1 = Character.getNumericValue(num1.charAt(i));
            int termProduct = (d1 * d2) + carry;
            partialProduct.insert(0, termProduct % 10);
            carry = termProduct / 10;
        }
        
        if (carry != 0) {
            partialProduct.insert(0, carry);
        }
        
        int trailingZeroes = num2.length() - 1 - n2Place;
        return appendZeroes(partialProduct, trailingZeroes).toString();
    }
    
    private StringBuilder appendZeroes(StringBuilder sb, int num) {
        if (num > 0) {
            return appendZeroes(sb, num - 1).append('0');
        }
        return sb;
    }
    
    private String add(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int digit1 = i >= 0 ? Character.getNumericValue(num1.charAt(i)) : 0;
            int digit2 = j >= 0 ? Character.getNumericValue(num2.charAt(j)) : 0;
            int digitSum = digit1 + digit2 + carry;
            sum.insert(0, digitSum % 10);
            carry = digitSum / 10;
            i--;
            j--;
        }
        
        if (carry > 0) {
            sum.insert(0, carry);
        }
        
        return sum.toString();
    }
}