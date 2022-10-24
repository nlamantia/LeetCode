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
        
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        
        while (!level.isEmpty()) {
            // compare level
            int levelSize = level.size();
            int start = 0, end = level.size() - 1;
            while (start < end) {
                if (!isSameNode(level.get(start++), level.get(end--))) {
                    return false;
                }
            }
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = level.remove(0);
                if (node != null) {
                    level.add(node.left);
                    level.add(node.right);
                }
            }
        }
        return true;
    }
    
    private boolean isSameNode(TreeNode n1, TreeNode n2) {
        return (n1 == null && n2 == null) || (n1 != null && n2 != null && n1.val == n2.val);
    }
}