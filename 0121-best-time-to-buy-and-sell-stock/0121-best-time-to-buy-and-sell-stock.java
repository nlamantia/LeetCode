class Solution {
    // O(n) time | O(1) space
    public int maxProfit(int[] prices) {
        int buy = 0, sell = 0;
        int maxProfit = 0;
        while (sell < prices.length - 1) {
            if (prices[sell] < prices[buy]) {
                buy = sell;
            } else {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
            sell++;
        }
        return Math.max(maxProfit, prices[sell] - prices[buy]);
    }
}