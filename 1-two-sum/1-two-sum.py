class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_dict = {}
        for i in range(len(nums)):
            if num_dict.get(nums[i], None) is None:
                num_dict[nums[i]] = []

            num_dict[nums[i]].append(i)
            
        for i in range(len(nums)):
            diff_pos = num_dict.get(target - nums[i], None)
            if diff_pos is not None:
                for pos in diff_pos:
                    if pos != i:
                        return [i, pos]
                    
        return None