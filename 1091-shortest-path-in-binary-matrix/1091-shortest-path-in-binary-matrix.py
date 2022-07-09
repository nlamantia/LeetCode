class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        N = len(grid)
        directions = [[i, j] for i in range(-1, 2) for j in range(-1, 2)]
        visit = set((N - 1, N - 1))
        memo = [[-1] * N for i in range(N)]
        
        def outOfBounds(r, c):
            return r in [-1, N] or c in [-1, N]
        
        q = deque([(N - 1, N - 1, 1)])
        while q:
            r, c, length = q.popleft()
            if grid[r][c]:
                continue
            memo[r][c] = min(memo[r][c], length) if memo[r][c] > 0 else length
            for dr, dc in directions:
                newR, newC = r + dr, c + dc
                if not outOfBounds(newR, newC) and (newR, newC) not in visit:
                    visit.add((newR, newC))
                    q.append([newR, newC, length + 1])
                
        return memo[0][0]