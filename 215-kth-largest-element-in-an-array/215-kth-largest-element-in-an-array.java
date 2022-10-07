class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthSmallest(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    
    private int findKthSmallest(int[] nums, int low, int high, int k) {
        int pivot = partition(nums, low, high);
        
        if (pivot == k - 1) {
            return nums[pivot];
        } else if (pivot < k - 1) {
            return findKthSmallest(nums, pivot + 1, high, k);
        } else {
            return findKthSmallest(nums, low, pivot - 1, k);
        }
    }
    
    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high], pivotIndex = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[pivotIndex];
                nums[pivotIndex] = temp;
                pivotIndex++;
            }
        }
        
        int temp = nums[high];
        nums[high] = nums[pivotIndex];
        nums[pivotIndex] = temp;
        
        return pivotIndex;
    }
}