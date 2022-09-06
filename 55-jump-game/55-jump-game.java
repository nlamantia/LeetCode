class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        Arrays.fill(canJump, false);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= nums.length - 1) {
                canJump[i] = true;
            } else {
                for (int j = 1; j <= nums[i] && !canJump[i]; j++) {
                    canJump[i] = canJump[i] || canJump[i + j];
                }
            }
        }
        
        return canJump[0];
    }
}