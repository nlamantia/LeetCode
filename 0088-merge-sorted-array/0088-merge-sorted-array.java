class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (p1 >= 0 && p2 >= 0) {
                nums1[i] = Math.max(nums1[p1], nums2[p2]);
                if (nums1[i] == nums2[p2]) {
                    p2--;
                } else {
                    p1--;
                }
            } else if (p1 >= 0) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
    }
}