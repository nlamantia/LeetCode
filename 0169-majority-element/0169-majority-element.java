class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        int maxNumber = Integer.MIN_VALUE, maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxNumber = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxNumber;
    }
}