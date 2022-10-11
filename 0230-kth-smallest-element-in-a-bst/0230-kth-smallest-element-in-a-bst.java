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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode kthSmallestNode = dfs(root, new AtomicInteger(0), k);
        return kthSmallestNode.val;
    }
    
    private TreeNode dfs(TreeNode root, AtomicInteger counter, int k) {
        TreeNode kthSmallestNode = null;
        if (root.left != null) {
            kthSmallestNode = dfs(root.left, counter, k);
        }
        
        if (kthSmallestNode != null) {
            return kthSmallestNode;
        }
        
        if (counter.incrementAndGet() == k) {
            return root;
        }
        
        if (root.right != null) {
            kthSmallestNode = dfs(root.right, counter, k);
        }
        return kthSmallestNode;
    }
}