class Solution {
    // O(n log n) time | O(n) space
    public List<String> summaryRanges(int[] nums) {
        Arrays.sort(nums);
        
        List<String> result = new LinkedList<>();
        Integer rangeStart = null;
        for (int i = 0; i < nums.length; i++) {
            if (rangeStart == null) {
                rangeStart = nums[i];
            } else if (!isConsecutive(nums[i - 1], nums[i])) {
                addRange(result, rangeStart, nums[i - 1]);
                rangeStart = nums[i];
            }
        }
        
        if (rangeStart != null) {
            addRange(result, rangeStart, nums[nums.length - 1]);
        }
        
        return result;
    }
    
    private boolean isConsecutive(long end, long start) {
        return Math.abs(end - start) <= 1;
    }
    
    private void addRange(List<String> result, Integer start, Integer end) {
        StringBuilder sb = new StringBuilder(start.toString());
        if (end > start) {
            sb.append("->").append(end);
        }
        result.add(sb.toString());
    }
}