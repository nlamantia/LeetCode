class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        minCost[cost.length - 1] = cost[cost.length - 1];
        for (int i = cost.length - 2; i >= 0; i--) {
            minCost[i] = cost[i] + Math.min(minCost[i + 1], minCost[i + 2]);
        }
        return Math.min(minCost[0], minCost[1]);
    }
}