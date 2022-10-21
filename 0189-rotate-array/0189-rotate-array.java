class Solution {
    // O(n) time | O(n) space
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[(nums.length - k + i) % nums.length];
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}