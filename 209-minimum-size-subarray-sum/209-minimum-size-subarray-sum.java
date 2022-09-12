class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0, minLength = nums.length + 1;
        int start = 0, end = 0;
        while (end < nums.length) {
            currentSum += nums[end++];
            while (currentSum >= target) {
                minLength = Math.min(minLength, end - start);
                currentSum -= nums[start++];
            }
        }
        return minLength == (nums.length + 1) ? 0 : minLength;
    }
}