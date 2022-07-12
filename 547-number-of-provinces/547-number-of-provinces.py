class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        N = len(isConnected)
        adj = { i: [] for i in range(N) }
        
        for i in range(N):
            for j in range(N):
                if i != j and isConnected[i][j]:
                    adj[i].append(j)
                    
        visit = set()
        
        def dfs(city):
            if city in visit:
                return
            
            visit.add(city)
            
            for neighbor in adj[city]:
                dfs(neighbor)
            
        provinces = 0
        for i in range(N):
            if i not in visit:
                dfs(i)
                provinces += 1
                
        return provinces
    
    # 0 -> [], 1 -> [], 2 -> []