class Solution {
    // O(m * n) time | O(1) space
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int row = matrix.length - 1; row >= 0; row--) {
            if (!checkDiagonal(matrix, row, 0)) return false;
        }
        
        for (int col = 1; col < matrix[0].length; col++) {
            if (!checkDiagonal(matrix, 0, col)) return false;
        }
        
        return true;
    }
    
    private boolean checkDiagonal(int[][] matrix, int row, int col) {
        int value = matrix[row][col];
        while (row < matrix.length && col < matrix[0].length) {
            if (matrix[row++][col++] != value) {
                return false;
            }
        }
        return true;
    }
}