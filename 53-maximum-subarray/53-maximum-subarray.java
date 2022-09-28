class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[nums.length - 1];
        int maxSum = currentSum;
        for (int i = nums.length - 2; i >= 0; i--) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}