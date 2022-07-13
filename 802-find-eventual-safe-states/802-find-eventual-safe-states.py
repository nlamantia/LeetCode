class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        N = len(graph)
        visit = set()
        safe = set()
        
        def dfs(node, path):
            if node in path:
                return False
            
            if node in safe:
                return True
            
            visit.add(node)
            path.add(node)
            
            for neighbor in graph[node]:
                if not dfs(neighbor, path):
                    return False
                
            safe.add(node)
            path.remove(node)
            return True
        
        
        for i in range(N):
            if i not in visit:
                dfs(i, set())
            
        safe = list(safe)
        safe.sort()
        return safe