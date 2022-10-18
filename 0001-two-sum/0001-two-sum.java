class Solution {
    // O(n) time | O(n) space
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numSet = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (numSet.containsKey(target - nums[i]) && numSet.get(target - nums[i]) != i) {
                return new int[] { i, numSet.get(target - nums[i]) };
            }
        }
        
        return null;
    }
}