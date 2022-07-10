class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        N = len(grid)
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        island = set()
        
        def outOfBounds(r, c):
            return r in [-1, N] or c in [-1, N]
        
        def dfs(r, c):
            if outOfBounds(r, c) or (r, c) in island or not grid[r][c]:
                return
            island.add((r, c))
            for dr, dc in directions:
                dfs(r + dr, c + dc)
                
        # use dfs to find one island and visit the whole island
        for r in range(N):
            for c in range(N):
                if grid[r][c]:
                    dfs(r, c)
                    break
            else:
                continue
            break
            
        # use bfs to find min distance to the other island
        q = deque()
        visit = set()
        for r, c in island:
            visit.add((r, c))
            for dr, dc in directions:
                newR, newC = r + dr, c + dc
                if not outOfBounds(newR, newC) and not grid[newR][newC]:
                    q.append((newR, newC, 0))
                    visit.add((newR, newC))
            
        while q:
            for i in range(len(q)):
                r, c, dist = q.popleft()
                if grid[r][c]:
                    return dist

                for dr, dc in directions:
                    newR, newC = r + dr, c + dc
                    if not outOfBounds(newR, newC) and (newR, newC) not in visit:
                        q.append((newR, newC, dist + 1))
                        visit.add((newR, newC))
            