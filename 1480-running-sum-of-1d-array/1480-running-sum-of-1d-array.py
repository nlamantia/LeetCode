class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        result = []
        for i in range(len(nums)):
            result.append(nums[i] if i == 0 else result[i - 1] + nums[i])
        return result