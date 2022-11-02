class Solution {
    // O(n log n) time | O(n) space
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        
        Deque<int[]> stack = new ArrayDeque<>();
        stack.offerLast(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] top = stack.peekLast();
            int[] cur = intervals[i];
            if (top[1] >= cur[0]) {
                top[0] = Math.min(top[0], cur[0]);
                top[1] = Math.max(top[1], cur[1]);
            } else {
                stack.offerLast(cur);
            }
        }
        
        int[][] res = new int[stack.size()][];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pollLast();
        }
        
        return res;
    }
}