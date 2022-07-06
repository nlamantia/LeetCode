class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visit = set()
        
        def outOfBounds(r, c):
            return r in [-1, ROWS] or c in [-1, COLS]
        
        def onPerimeter(r, c):
            return r in [0, ROWS - 1] or c in [0, COLS - 1]
        
        def dfs(r, c, cellOperation = None):
            if outOfBounds(r, c) or (r, c) in visit or grid[r][c]:
                return
            visit.add((r, c))
            
            for dr, dc in directions:
                dfs(r + dr, c + dc)
                
        for r in range(ROWS):
            for c in range(COLS):
                if onPerimeter(r, c) and (r, c) not in visit and not grid[r][c]:
                    dfs(r, c)
            
        closedIslands = 0
        for r in range(ROWS):
            for c in range(COLS):
                if (r, c) not in visit and not grid[r][c]:
                    dfs(r, c)
                    closedIslands += 1
                    
        return closedIslands