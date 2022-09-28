class Solution {
    // O(n) time | O(1) space
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int start, int end) {
        int currentMoney = Integer.MIN_VALUE, neighborMoney = Integer.MIN_VALUE;
        for (int i = end; i >= start; i--) {
            int skipNeighborMoney = neighborMoney;
            neighborMoney = currentMoney;
            if (i == end) {
                currentMoney = nums[i];
            } else if (i == end - 1) {
                currentMoney = Math.max(nums[i], neighborMoney);
            } else {
                currentMoney = Math.max(nums[i] + skipNeighborMoney, neighborMoney);
            }
        }
        return Math.max(currentMoney, neighborMoney);
    }
}