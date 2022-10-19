class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return target <= nums[start] ? start : end;
    }
}