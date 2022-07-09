class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(heights), len(heights[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        atlantic, pacific = set(), set()
        
        def bordersPacific(r, c):
            return r == 0 or c == 0
        
        def bordersAtlantic(r, c):
            return r == ROWS - 1 or c == COLS - 1
        
        def inOcean(r, c):
            return r in [-1, ROWS] or c in [-1, COLS]
        
        def dfs(r, c, prev, res):
            if inOcean(r, c) or (r, c) in res or heights[r][c] < prev:
                return 
            res.add((r, c))
            for dr, dc in directions:
                dfs(r + dr, c + dc, heights[r][c], res)
                
        for r in range(ROWS):
            for c in range(COLS):
                if bordersPacific(r, c):
                    dfs(r, c, -1, pacific)
                    
                if bordersAtlantic(r, c):
                    dfs(r, c, -1, atlantic)
                    
        res = []
        for r in range(ROWS):
            for c in range(COLS):
                if (r, c) in atlantic and (r, c) in pacific:
                    res.append([r, c])
                    
        return res
            