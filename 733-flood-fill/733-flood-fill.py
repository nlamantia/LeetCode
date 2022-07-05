class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        ROWS, COLS = len(image), len(image[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        visit = set()
        original_color = image[sr][sc]
        
        def out_of_bounds(r, c):
            return r < 0 or c < 0 or r == ROWS or c == COLS
        
        def dfs(r, c):
            if out_of_bounds(r, c) or (r, c) in visit or image[r][c] != original_color:
                return
            
            visit.add((r, c))
            image[r][c] = color
            for dr, dc in directions:
                dfs(r + dr, c + dc)
                
        dfs(sr, sc)
        return image