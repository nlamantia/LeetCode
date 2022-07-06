class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visit = set()
        maxArea = 0
        
        def outOfBounds(r, c):
            return r in [-1, ROWS] or c in [-1, COLS]
        
        def dfs(r, c):
            if outOfBounds(r, c) or (r, c) in visit or not grid[r][c]:
                return 0
            
            visit.add((r, c))
            res = 1
            for dr, dc in directions:
                res += dfs(r + dr, c + dc)
                
            return res
        
        for r in range(ROWS):
            for c in range(COLS):
                if (r, c) not in visit and grid[r][c]:
                    maxArea = max(maxArea, dfs(r, c))
                    
        return maxArea