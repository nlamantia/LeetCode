class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[nums.length - 1] = 0;
        
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= Math.min(nums.length - 1 - i, nums[i]); j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i + j]);
            }
        }
        
        return dp[0];
    }
}