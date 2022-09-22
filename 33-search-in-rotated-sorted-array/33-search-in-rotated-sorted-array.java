class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high - 1) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (isInRightHalf(nums, middle, high, target)) {
                low = middle;
            } else {
                high = middle;
            }
        }
        
        if (nums[low] == target) {
            return low;
        } else if (nums[high] == target) {
            return high;
        }
        
        return -1;
    }
    
    private boolean isInRightHalf(int[] nums, int middle, int high, int target) {
        // mid < high, mid < target, target < high
        // mid > high, target < high
        // mid > high, target > mid
        return (nums[middle] > nums[high] && (target > nums[middle] || target <= nums[high]))
            || (nums[middle] < nums[high] && nums[middle] < target && target <= nums[high]);
    }
}