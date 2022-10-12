class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        int perimeter = 0;
        for (int i = nums.length - 3; i < nums.length; i++) {
            perimeter += nums[i];
        }
        
        int start = nums.length - 3;
        while (start > 0 && !isValidTriangle(nums, start, perimeter)) {
            perimeter -= nums[start + 2];
            start--;
            perimeter += nums[start];
        }
        
        return isValidTriangle(nums, start, perimeter) ? perimeter : 0;
    }
    
    private boolean isValidTriangle(int[] nums, int start, int perimeter) {
        for (int i = start; i < start + 3; i++) {
            for (int j = i + 1; j < start + 3; j++) {
                int sumOfTwoSides = nums[i] + nums[j];
                int thirdSide = perimeter - sumOfTwoSides;
                if (sumOfTwoSides <= thirdSide) {
                    return false;
                }
            }
        }
        return true;
    }
}