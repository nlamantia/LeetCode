class Solution:
    def countSubIslands(self, grid1: List[List[int]], grid2: List[List[int]]) -> int:
        ROWS, COLS = len(grid1), len(grid1[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visit = set()
        
        def outOfBounds(r, c):
            return r in [-1, ROWS] or c in [-1, COLS]
        
        def dfs(r, c):
            if outOfBounds(r, c) or (r, c) in visit or not grid2[r][c]:
                return True
            print((r, c))
            visit.add((r, c))
            
            res = grid1[r][c] == 1
            for dr, dc in directions:
                res = res & dfs(r + dr, c + dc)
                
            return res
        
        res = 0
        for r in range(ROWS):
            for c in range(COLS):
                if (r, c) not in visit and grid2[r][c] and dfs(r, c):
                    res += 1
                    
        return res