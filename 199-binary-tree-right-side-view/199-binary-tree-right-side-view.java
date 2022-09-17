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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) return view;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                if (view.size() < level) {
                    view.add(node.val);
                }
                
                if (node.right != null) q.offer(node.right);
                if (node.left != null) q.offer(node.left);
            }
            level++;
        }
        return view;
    }
}