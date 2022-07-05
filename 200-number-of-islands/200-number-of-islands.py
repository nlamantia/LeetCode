class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        ROWS, COLS = len(grid), len(grid[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visit = set()
        count = 0
        
        def dfs(r, c):
            if r in [-1, ROWS] or c in [-1, COLS] or (r, c) in visit or grid[r][c] == "0":
                return
            visit.add((r, c))
            for dr, dc in directions:
                dfs(r + dr, c + dc)
            
        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == "1" and (r, c) not in visit:
                    count += 1
                    dfs(r, c)
                    
        return count