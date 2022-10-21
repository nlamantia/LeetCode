class Solution {
    // O(n) time | O(1) space
    public void moveZeroes(int[] nums) {
        int z = 0, nz = 0;
        while (z < nums.length && nz < nums.length) {
            // find next zero
            while (z < nums.length && nums[z] != 0) {
                z++;
            }
            
            // find next non-zero
            nz = z;
            while (nz < nums.length && nums[nz] == 0) {
                nz++;
            }
            
            // swap the next zero with the next non-zero
            if (z < nums.length && nz < nums.length) {
                nums[z] = nums[nz];
                nums[nz] = 0;
            }
            
            z++;
        }
    }
}