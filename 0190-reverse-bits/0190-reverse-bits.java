public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0, base = 1;
        for (int i = 0; i < 32; i++) {
            if (i > 0) result = result << 1;
            result += (n & base) == base ? 1 : 0;
            base = base << 1;
        }
        return result;
    }
}