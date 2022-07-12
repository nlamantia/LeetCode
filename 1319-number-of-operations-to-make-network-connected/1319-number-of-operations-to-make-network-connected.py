class Solution:
    def makeConnected(self, n: int, connections: List[List[int]]) -> int:
        if len(connections) < n - 1:
            return -1
        
        adj = { i: [] for i in range(n) }
        for i, j in connections:
            adj[i].append(j)
            adj[j].append(i)
            
        visit = set()
        
        def dfs(computer):
            if computer in visit:
                return
            
            visit.add(computer)
            for connection in adj[computer]:
                dfs(connection)
                
        connectionGroups = 0
        for c in range(n):
            if c not in visit:
                dfs(c)
                connectionGroups += 1
                
        return connectionGroups - 1
    
    # 0 -> [1, 2], 1 -> [0], 2 -> [0, 3], 3 -> [2, 4], 4 -> [3]