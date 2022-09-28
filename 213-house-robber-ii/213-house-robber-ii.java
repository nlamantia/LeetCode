class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    private int rob(int[] nums, int start, int end) {
        int[] money = new int[end - start + 1];
        for (int i = end; i >= start; i--) {
            if (i == end) {
                money[i - start] = nums[i];
            } else if (i == end - 1) {
                money[i - start] = Math.max(nums[i], nums[i + 1]);
            } else {
                money[i - start] = Math.max(nums[i] + money[i - start + 2], money[i - start + 1]);
            }
        }
        return end - start > 0 ? Math.max(money[0], money[1]) : money[0];
    }
}