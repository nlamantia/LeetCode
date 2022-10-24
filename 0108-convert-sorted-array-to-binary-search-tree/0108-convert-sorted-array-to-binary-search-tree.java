/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start < end) {
            int root = start + (end - start) / 2;
            TreeNode node = new TreeNode(nums[root]);
            node.left = sortedArrayToBST(nums, start, root);
            node.right = sortedArrayToBST(nums, root + 1, end);
            return node;
        }
        return null;
    }
}