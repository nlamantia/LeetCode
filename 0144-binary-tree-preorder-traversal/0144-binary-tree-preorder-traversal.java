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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            traverse(root.left, result);
            traverse(root.right, result);
        }
    }
}