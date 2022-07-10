class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        ROWS, COLS = len(maze), len(maze[0])
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        
        def outOfBounds(r, c):
            return r in [-1, ROWS] or c in [-1, COLS]
        
        def isExit(r, c):
            return (r in [0, ROWS - 1] or c in [0, COLS - 1]) and maze[r][c] == "."
        
        q = deque([(entrance[0], entrance[1], 0)])
        visit = set([(entrance[0], entrance[1])])
        while q:
            r, c, dist = q.popleft()
            if isExit(r, c) and [r, c] != entrance:
                return dist
            
            for dr, dc in directions:
                newR, newC = r + dr, c + dc
                if not outOfBounds(newR, newC) and (newR, newC) not in visit and maze[newR][newC] != "+":
                    q.append((newR, newC, dist + 1))
                    visit.add((newR, newC))
            
        return -1
                    