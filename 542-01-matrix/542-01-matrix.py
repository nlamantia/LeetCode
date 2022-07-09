class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(mat), len(mat[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        memo = [[0] * COLS for i in range(ROWS)]
        visit = set()
        
        def outOfBounds(r, c):
            return r in [-1, ROWS] or c in [-1, COLS]
        
        q = deque()
        for r in range(ROWS):
            for c in range(COLS):
                if not mat[r][c]:
                    q.append((r, c, 0))
                    visit.add((r, c))
                    
        while q:
            r, c, dist = q.popleft()
            memo[r][c] = dist
            for dr, dc in directions:
                newR, newC = r + dr, c + dc
                if not outOfBounds(newR, newC) and (newR, newC) not in visit:
                    visit.add((newR, newC))
                    q.append([newR, newC, dist + 1])
                    
        return memo
                    