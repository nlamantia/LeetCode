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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        invertTree(root.right);
        return isSameTree(root.left, root.right);
    }
    
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        boolean result = true;
        if (root1 != null && root2 != null) {
            result &= isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        }
        
        return result && isSameNode(root1, root2);
    }
    
    private void invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
    
    private boolean isSameNode(TreeNode n1, TreeNode n2) {
        return (n1 == null && n2 == null) || (n1 != null && n2 != null && n1.val == n2.val);
    }
}