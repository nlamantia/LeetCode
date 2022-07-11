class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        left, right = 0, 0
        
        for i in range(1, len(nums)):
            right += nums[i]
            
        pivot = 0
        while pivot < len(nums) and left != right:
            left += nums[pivot]
            pivot += 1
            if pivot < len(nums):
                right -= nums[pivot]
            
        return pivot if pivot < len(nums) else -1