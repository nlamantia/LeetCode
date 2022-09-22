class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high - 1) {
            int middle = low + (high - low) / 2;
            if (nums[middle] < nums[middle - 1]) {
                return nums[middle];
            } else if (nums[middle] < nums[high]) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return Math.min(nums[low], nums[high]);
    }
}