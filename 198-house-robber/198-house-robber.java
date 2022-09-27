class Solution {
    public int rob(int[] nums) {
        int[] money = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 2 < nums.length) {
                money[i] = Math.max(money[i + 1], nums[i] + money[i + 2]);
            } else if (i + 1 < nums.length) {
                money[i] = Math.max(nums[i], nums[i + 1]);
            } else {
                money[i] = nums[i];
            }
        }
        return nums.length > 1 ? Math.max(money[0], money[1]) : money[0];
    }
}