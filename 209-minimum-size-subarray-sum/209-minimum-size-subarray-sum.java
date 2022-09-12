class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0, minLength = nums.length + 1;
        int start = 0, end = 0;
        while (end < nums.length) {
            currentSum += nums[end];
            if (currentSum >= target) {
                while (currentSum - nums[start] >= target) {
                    currentSum -= nums[start];
                    start++;
                }
                minLength = Math.min(minLength, end - start + 1);
                currentSum -= nums[start];
                start++;
            }
            end++;
        }
        return minLength == (nums.length + 1) ? 0 : minLength;
    }
}