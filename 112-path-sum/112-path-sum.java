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
    // Worst case - binary stick/linked list: O(n) time | O(n) space (call stack)
    // Best case - almost complete binary tree: O(log n) time | O(log n) space (call stack)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            return true;
        }
        
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}