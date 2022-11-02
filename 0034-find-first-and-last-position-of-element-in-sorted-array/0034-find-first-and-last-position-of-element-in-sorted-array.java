class Solution {
    // O(log n) time | O(1) space
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] { -1, -1 };
        return new int[] { findFirstPosition(nums, target), findLastPosition(nums, target) };
    }
    
    private int findFirstPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (nums[middle] >= target) {
                end = middle;
            } else {
                start = middle;
            }
        }
        
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }
    
    private int findLastPosition(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (nums[middle] <= target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        
        if (nums[end] == target) {
            return end;
        } else if (nums[start] == target) {
            return start;
        }
        return -1;
    }
}