class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high - 1) {
            int middle = low + (high - low) / 2;
            if (isPeak(nums, middle)) {
                return middle;
            } else if (isStrictlyIncreasing(nums, middle)) {
                low = middle;
            } else {
                high = middle;
            }
        }
        return nums[low] > nums[high] ? low : high;
    }
    
    private boolean isPeak(int[] nums, int middle) {
        if (middle > 0 && middle < nums.length - 1) {
            return nums[middle - 1] < nums[middle] && nums[middle] > nums[middle + 1];
        } else if (middle > 0) {
            return nums[middle - 1] < nums[middle];
        } else {
            return nums[middle] > nums[middle + 1];
        }
    }
    
    private boolean isStrictlyIncreasing(int[] nums, int middle) {
        if (middle > 0 && middle < nums.length - 1) {
            return nums[middle - 1] < nums[middle] && nums[middle] < nums[middle + 1];
        } else if (middle > 0) {
            return nums[middle - 1] < nums[middle];
        } else {
            return nums[middle] < nums[middle + 1];
        }
    }
}