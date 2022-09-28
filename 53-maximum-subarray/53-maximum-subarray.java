class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum = nums[nums.length - 1]; // 0
        int maxSum = currentSum; // 0
        for (int i = nums.length - 2; i >= 0; i--) { // i = 
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}