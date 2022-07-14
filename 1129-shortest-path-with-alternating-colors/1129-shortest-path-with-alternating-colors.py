class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        RED, BLUE = -1, 1
        
        redNeighbors = { i:[] for i in range(n) }
        for i, j in redEdges:
            redNeighbors[i].append(j)
        
        blueNeighbors = { i:[] for i in range(n) }
        for i, j in blueEdges:
            blueNeighbors[i].append(j)
            
        answer = [-1] * n
        redVisit, blueVisit = set([0]), set([0])
        q = deque([(0, 0, RED), (0, 0, BLUE)])
        while q:
            node, dist, color = q.popleft()
            if answer[node] == -1:
                answer[node] = dist
            else:
                answer[node] = min(answer[node], dist)
            
            neighbors = redNeighbors if color == RED else blueNeighbors
            visit = redVisit if color == RED else blueVisit
            for neighbor in neighbors[node]:
                if neighbor not in visit:
                    q.append((neighbor, dist + 1, color * -1))
                    visit.add(neighbor)
                
        return answer
    
    # red: 0->[], 1->[4], 2->[4], 3->[2], 4->[1]
    # blue: 0->[4], 1->[0], 2->[3], 3->[], 4->[0, 3, 4]