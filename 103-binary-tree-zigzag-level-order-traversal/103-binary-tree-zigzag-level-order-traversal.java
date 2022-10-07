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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        enqueueNode(q, root);
        
        int level = 1;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelOrder = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (level % 2 == 0) {
                    levelOrder.add(0, node.val);
                } else {
                    levelOrder.add(node.val);
                }
                
                enqueueNode(q, node.left);
                enqueueNode(q, node.right);
            }
            
            result.add(levelOrder);
            level++;
        }
        
        return result;
    }
    
    private void enqueueNode(Queue<TreeNode> q, TreeNode node) {
        if (node != null) q.offer(node);
    }
}