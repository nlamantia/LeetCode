# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
    num_hash = nums.each.with_index.each_with_object({}) do |(num, idx), hash|
        hash[num] ||= []
        hash[num].push(idx)
    end
    
    result = nil
    nums.each.with_index do |num, idx|
        diff_pos = num_hash[target - num] || []
        other_pos = diff_pos.detect { |pos| pos != idx }
        result = [idx, other_pos] unless other_pos.nil?
        break unless result.nil?
    end
    
    result
end