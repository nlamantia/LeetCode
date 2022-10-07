class Solution {
    public int minBitFlips(int start, int goal) {
        int x = 1, bits = 0;
        while (x <= start || x <= goal) {
            if ((start & x) != (goal & x)) {
                bits++;
            }
            x <<= 1;
        }
        return bits;
    }
}