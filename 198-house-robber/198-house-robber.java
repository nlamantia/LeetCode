class Solution {
    // O(n) time | O(1) space
    public int rob(int[] nums) {
        if (nums.length < 2) return nums[0];
        
        int currentMoney = -1, neighborMoney = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int skipNeighborMoney = neighborMoney;
            neighborMoney = currentMoney;
            if (i + 2 < nums.length) {
                currentMoney = Math.max(neighborMoney, nums[i] + skipNeighborMoney);
            } else if (i + 1 < nums.length) {
                currentMoney = Math.max(nums[i], neighborMoney);
            } else {
                currentMoney = nums[i];
            }
        }
        
        return Math.max(currentMoney, neighborMoney);
    }
}