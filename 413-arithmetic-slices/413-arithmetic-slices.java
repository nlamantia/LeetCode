class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length <= 2) return 0;
        
        int[] memo = new int[nums.length];
        for (int i = nums.length - 3; i >= 0; i--) {
            int diff = nums[i + 1] - nums[i];
            for (int j = i + 1; j < nums.length - 1 && nums[j + 1] - nums[j] == diff; j++) {
                memo[i]++;
            }
            memo[i] += memo[i + 1];
        }
        return memo[0];
    }
}