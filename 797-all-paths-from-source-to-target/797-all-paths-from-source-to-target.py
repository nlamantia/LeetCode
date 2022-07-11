class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        N = len(graph)
        
        allPaths = []
        def dfs(v, path):
            if v in path:
                return
            
            path.append(v)
            if v == N - 1:
                allPaths.append(path)
                return
            
            for edge in graph[v]:
                dfs(edge, path.copy())
                
        dfs(0, [])
        return allPaths