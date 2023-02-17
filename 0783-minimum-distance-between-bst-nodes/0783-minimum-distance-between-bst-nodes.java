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
    // O(n) time | O(n) space
    public int minDiffInBST(TreeNode root) {
        List<Integer> order = new LinkedList<>();
        traverse(root, order);
        
        int minDiff = Integer.MAX_VALUE;
        int previous = order.remove(0);
        while (!order.isEmpty()) {
            int current = order.remove(0);
            minDiff = Math.min(minDiff, current - previous);
            previous = current;
        }
        
        return minDiff;
    }
    
    private void traverse(TreeNode root, List<Integer> order) {
        if (root != null) {
            traverse(root.left, order);
            order.add(root.val);
            traverse(root.right, order);
        }
    }
}