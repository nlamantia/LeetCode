class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        
        int carry = 0;
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            int nextNumDigit = i >= 0 ? num[i] : 0;
            int nextKDigit = k % 10;
            int digitSum = carry + nextNumDigit + nextKDigit;
            result.add(0, digitSum % 10);
            carry = digitSum / 10;
            k /= 10;
            i--;
        }
        
        if (carry > 0) {
            result.add(0, carry);
        }
        
        return result;
    }
}