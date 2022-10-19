class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = i % 2 == 0 ? result[i / 2] : result[i - 1] + 1;
        }
        return result;
    }
}