/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q).ancestor;
    }
    
    private AncestorInfo lca(TreeNode root, TreeNode p, TreeNode q) {
        AncestorInfo info = new AncestorInfo(root);
        if (root == null) {
            return info;
        }
        
        AncestorInfo leftInfo = lca(root.left, p, q);
        if (leftInfo.foundLCA()) return leftInfo;
        
        AncestorInfo rightInfo = lca(root.right, p, q);
        if (rightInfo.foundLCA()) return rightInfo;
        
        info.foundP = leftInfo.foundP || rightInfo.foundP || root == p;
        info.foundQ = leftInfo.foundQ || rightInfo.foundQ || root == q;
        
        return info;
    }
    
    private class AncestorInfo {
        TreeNode ancestor;
        boolean foundP = false;
        boolean foundQ = false;
        
        AncestorInfo(TreeNode ancestor) {
            this.ancestor = ancestor;
        }
        
        boolean foundLCA() {
            return foundP && foundQ;
        }
    }
}