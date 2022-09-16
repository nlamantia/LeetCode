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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // base case
        List<List<Integer>> overallOrder = new ArrayList<>();
        if (root == null) return overallOrder;
        
        // BFS
        ListNode head = null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        
        while (!q.isEmpty()) {
            // create list of integers at each level
            List<Integer> levelOrder = new ArrayList<>();
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                levelOrder.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            
            // create a linked list node per level and tack it onto the head
            head = addLevelToLinkedList(head, levelOrder);
        }
        
        // aggregate the level order lists into a combined list
        ListNode current = head;
        while (current != null) {
            overallOrder.add(current.order);
            current = current.next;
        }
        return overallOrder;
    }
    
    private ListNode addLevelToLinkedList(ListNode head, List<Integer> levelOrder) {
        ListNode newNode = new ListNode(levelOrder);
        newNode.next = head;
        return newNode;
    }
    
    class ListNode {
        List<Integer> order;
        ListNode next;
        
        ListNode(List<Integer> order) {
            this.order = order;
        }
    }
}