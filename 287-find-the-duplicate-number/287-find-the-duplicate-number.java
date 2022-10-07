class Solution {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            int lessCount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    lessCount++;
                }
            }
            
            if (lessCount >= mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        int startCount = 0, endCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == start) {
                startCount++;
            } else if (nums[i] == end) {
                endCount++;
            }
        }
        
        return startCount > endCount ? start : end;
    }
}