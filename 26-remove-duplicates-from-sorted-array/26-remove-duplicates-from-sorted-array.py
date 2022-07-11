class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)
        
        i, k = 1, len(nums)
        while i < k:
            if nums[i] == nums[i - 1]:
                nums.append(nums.pop(i))
                k -= 1
            else:
                i += 1
                
        return k