class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> result = new LinkedList<>();
        
        int carry = 0;
        int i = num.length - 1;
        while (i >= 0 || k > 0) {
            int nextNumDigit = i >= 0 ? num[i] : 0;
            int nextKDigit = k % 10;
            int digitSum = carry + nextNumDigit + nextKDigit;
            result.addFirst(digitSum % 10);
            carry = digitSum / 10;
            k /= 10;
            i--;
        }
        
        if (carry > 0) {
            result.addFirst(carry);
        }
        
        return result;
    }
}