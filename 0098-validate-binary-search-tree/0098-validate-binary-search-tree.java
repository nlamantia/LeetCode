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
    public boolean isValidBST(TreeNode root) {
        return validateTree(root).isValidBST;
    }
    
    private TreeStats validateTree(TreeNode root) {
        if (root == null) return null;
        
        TreeStats leftStats = validateTree(root.left);
        TreeStats rightStats = validateTree(root.right);
        
        TreeStats stats = new TreeStats();
        stats.min = leftStats == null ? root.val : Math.min(root.val, leftStats.min);
        stats.max = rightStats == null ? root.val : Math.max(root.val, rightStats.max);
        stats.isValidBST = isValidBST(root, leftStats, rightStats);
        
        return stats;
    }
    
    private boolean isValidBST(TreeNode root, TreeStats leftStats, TreeStats rightStats) {
        boolean result = true;
        if (leftStats != null) {
            result = result && leftStats.isValidBST && root.val > leftStats.max;
        }
        
        if (rightStats != null) {
            result = result && rightStats.isValidBST && root.val < rightStats.min;
        }
        
        return result;
    }
    
    private class TreeStats {
        int min;
        int max;
        boolean isValidBST = true;
    }
}