class Solution {
    // O(n log n) time | O(1) space
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length && nums[i] == i; i++);
        return i;
    }
}