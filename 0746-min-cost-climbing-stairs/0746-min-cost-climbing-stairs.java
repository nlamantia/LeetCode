class Solution {
    // O(n) time | O(1) space
    public int minCostClimbingStairs(int[] cost) {
        int first = cost[cost.length - 1], second = 0;
        for (int i = cost.length - 2; i >= 0; i--) {
            int temp = first;
            first = cost[i] + Math.min(first, second);
            second = temp;
        }
        return Math.min(first, second);
    }
}