class Solution {
    // 
    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        int i = nums.length - 1;
        int left = 0, right = nums.length - 1;
        while (i >= 0) {
            squares[i] = Math.max(nums[left] * nums[left], nums[right] * nums[right]);
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                left++;
            } else {
                right--;
            }
            i--;
        }
        return squares;
    }
}