class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        N = len(grid)
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        memo = [[-1] * N for i in range(N)]
        
        def outOfBounds(r, c):
            return r in [-1, N] or c in [-1, N]
        
        visit = set()
        q = deque()
        for r in range(N):
            for c in range(N):
                if grid[r][c]:
                    q.append((r, c))
                    visit.add((r, c))
        
        level = 0
        while q:
            for i in range(len(q)):
                r, c = q.popleft()
                memo[r][c] = level
                for dr, dc in directions:
                    newR, newC = r + dr, c + dc
                    if not outOfBounds(newR, newC) and (newR, newC) not in visit and not grid[newR][newC]:
                        q.append((newR, newC))
                        visit.add((newR, newC))
                    
            level += 1
            
        maxDistance = -1
        for r in range(N):
            for c in range(N):
                if memo[r][c] > maxDistance:
                    maxDistance = memo[r][c]
                    
        return maxDistance if maxDistance > 0 else -1