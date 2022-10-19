class Solution {
    public int pivotIndex(int[] nums) {
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }
        
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) {
                return i;
            } else {
                left += nums[i];
            }
        }
        return -1;
    }
}