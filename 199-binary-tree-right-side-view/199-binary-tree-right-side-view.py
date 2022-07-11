# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        visibleNodes = {}
        
        def dfs(node, depth):
            if node is None:
                return
            
            if depth not in visibleNodes:
                visibleNodes[depth] = node
            
            dfs(node.right, depth + 1)
            dfs(node.left, depth + 1)
            
        dfs(root, 0)
        
        result = []
        depth = 0
        while depth in visibleNodes:
            result.append(visibleNodes[depth].val)
            depth += 1
            
        return result