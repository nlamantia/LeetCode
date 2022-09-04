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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelSums = new ArrayList<>();
        List<Double> levelCounts = new ArrayList<>();
        
        preorderTraversal(root, 0, levelSums, levelCounts);
        
        List<Double> averages = new ArrayList<>();
        for (int i = 0; i < levelSums.size(); i++) {
            averages.add(levelSums.get(i) / levelCounts.get(i));
        }
        return averages;
    }
    
    private void preorderTraversal(TreeNode root, int depth, List<Double> sums, List<Double> counts) {
        if (depth >= sums.size()) {
            sums.add(depth, 0.0);
            counts.add(depth, 0.0);
        }
        counts.set(depth, counts.get(depth) + 1);
        sums.set(depth, sums.get(depth) + root.val);
        
        if (root.left != null) {
            preorderTraversal(root.left, depth + 1, sums, counts);
        }
        
        if (root.right != null) {
            preorderTraversal(root.right, depth + 1, sums, counts);
        }
    }
}