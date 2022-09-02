class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        
        for (int col = 0; col < s2.length(); col++) {
            memo[0][col + 1] = memo[0][col] + (int) s2.charAt(col);
        }
        
        for (int row = 0; row < s1.length(); row++) {
            memo[row + 1][0] = memo[row][0] + (int) s1.charAt(row);
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    memo[i][j] = getMinimumSum(memo, i - 1, j - 1);
                } else {
                    memo[i][j] = Math.min(
                        getMinimumSum(memo, i - 1, j) + (int) s1.charAt(i - 1),
                        getMinimumSum(memo, i, j - 1) + (int) s2.charAt(j - 1)
                    );
                }
            }    
        }
        
        return getMinimumSum(memo, s1.length(), s2.length());
    }
    
    private int getMinimumSum(int[][] memo, int row, int col) {
        return isOutOfBounds(memo, row, col) ? 0 : memo[row][col];
    }
    
    private boolean isOutOfBounds(int[][] memo, int row, int col) {
        return row < 0 || row >= memo.length || col < 0 || col >= memo[0].length;
    }
}