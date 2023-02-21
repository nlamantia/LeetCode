class Solution {
    // O(log n) time | O(1) space
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (!isDuplicate(nums, middle)) {
                return nums[middle];
            } else {
                int dup = nums[middle] == nums[middle - 1] ? middle - 1 : middle + 1;
                if (Math.min(middle, dup) % 2 == 0) {
                    // search right
                    start = middle;
                } else {
                    // search left
                    end = middle;
                }
            }
        }
        
        return isDuplicate(nums, start) ? nums[end] : nums[start];
    }
    
    private boolean isDuplicate(int[] nums, int i) {
        return (i > 0 && nums[i] == nums[i - 1])
            || (i < nums.length - 1 && nums[i] == nums[i + 1]);
    }
}