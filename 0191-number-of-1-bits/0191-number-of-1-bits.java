public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int numOfDigits = 0;
        int base = 1;
        for (int i = 0; i < 32; i++) {
            numOfDigits += (n & base) == base ? 1 : 0;
            base = base << 1;
        }
        return numOfDigits;
    }
}