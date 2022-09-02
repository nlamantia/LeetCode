class Solution {
    public int arrangeCoins(int n) {
        int row = 1;
        while (n - row > 0) {
            n -= row;
            row++;
        }
        
        return n - row == 0 ? row : row - 1;
    }
}