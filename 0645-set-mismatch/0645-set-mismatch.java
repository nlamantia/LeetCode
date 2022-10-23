class Solution {
    // O(n) time | O(n) space
    public int[] findErrorNums(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int[] result = new int[2];
        for (int num : nums) {
            if (numSet.contains(num)) {
                result[0] = num;
            } else {
                numSet.add(num);
            }
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                result[1] = i;
            }
        }
        return result;
    }
}