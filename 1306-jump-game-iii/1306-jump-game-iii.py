class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        visit = set()
        
        def outOfBounds(idx):
            return idx < 0 or idx >= len(arr)
        
        def dfs(idx):
            if outOfBounds(idx) or idx in visit:
                return False
            
            visit.add(idx)
            if not arr[idx]:
                return True
            
            return dfs(idx + arr[idx]) or dfs(idx - arr[idx])
        
        return dfs(start)