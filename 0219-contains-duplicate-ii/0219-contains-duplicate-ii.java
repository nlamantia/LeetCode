class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false;
        
        Set<Integer> window = new HashSet<>();
        int start = 0, end = 0;
        while (end < nums.length) {
            if (end - start > k) {
                window.remove(nums[start]);
                start++;
            }
            
            if (window.contains(nums[end])) {
                return true;
            }
            
            window.add(nums[end]);
            end++;
        }
        return false;
    }
}