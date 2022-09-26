class Solution {
    public int climbStairs(int n) {
        int stepWays1 = 1, stepWays2 = 1;
        
        for (int i = n - 2; i >= 0; i--) {
            int newStepWays = stepWays1 + stepWays2;
            stepWays2 = stepWays1;
            stepWays1 = newStepWays;
        }
        
        return stepWays1;
    }
}