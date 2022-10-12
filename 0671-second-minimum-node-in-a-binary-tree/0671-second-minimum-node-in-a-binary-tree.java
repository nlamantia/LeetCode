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
    public int findSecondMinimumValue(TreeNode root) {
        if (root.left != null) {
            if (root.left.val == root.val && root.right.val == root.val) {
                return minNonNegative(findSecondMinimumValue(root.left), findSecondMinimumValue(root.right));
            } else if (root.left.val == root.val) {
                return minNonNegative(findSecondMinimumValue(root.left), root.right.val);
            } else {
                return minNonNegative(findSecondMinimumValue(root.right), root.left.val);
            }
        }
        return -1;
    }
    
    private int minNonNegative(int x, int y) {
        if (x == -1) {
            return y;
        } else if (y == -1) {
            return x;
        } else {
            return Math.min(x, y);
        }
    }
}