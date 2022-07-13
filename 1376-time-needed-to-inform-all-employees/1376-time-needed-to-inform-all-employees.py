class Solution:
    def numOfMinutes(self, n: int, headID: int, manager: List[int], informTime: List[int]) -> int:
        hier = { i: [] for i in range(n) }
        for i in range(n):
            if manager[i] != -1:
                hier[manager[i]].append(i)
        
        informed = set()
        def dfs(employee, time):
            if employee in informed:
                return 0
            
            informed.add(employee)
            
            maxTime = time
            for subordinate in hier[employee]:
                maxTime = max(maxTime, dfs(subordinate, time + informTime[employee]))
                
            return maxTime
            
        return dfs(headID, 0)
            