class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n + 1];
        ways[n] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 <= n) ways[i] += ways[i + 1];
            if (i + 2 <= n) ways[i] += ways[i + 2];
        }
        return ways[0];
    }
}