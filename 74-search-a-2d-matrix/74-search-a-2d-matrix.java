class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        return row >= 0 && isInRow(matrix, row, target);
    }
    
    private int findRow(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (isInRowRange(matrix, middle, target)) {
                return middle;
            } else if (isInLowerRow(matrix, middle, target)) {
                end = middle;
            } else {
                start = middle;
            }
        }
        
        if (isInRowRange(matrix, end, target)) {
            return end;
        } else if (isInRowRange(matrix, start, target)) {
            return start;
        }
        return -1;
    }
    
    private boolean isInRow(int[][] matrix, int row, int target) {
        int start = 0, end = matrix[row].length - 1;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (matrix[row][middle] == target) {
                return true;
            } else if (matrix[row][middle] > target) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return matrix[row][start] == target || matrix[row][end] == target;
    }
    
    private boolean isInLowerRow(int[][] matrix, int row, int target) {
        int maxValue = row == 0 ? matrix[row][0] : matrix[row - 1][matrix[row].length - 1];
        return target <= maxValue;
    }
    
    private boolean isInRowRange(int[][] matrix, int row, int target) {
        return matrix[row][0] <= target && target <= matrix[row][matrix[row].length - 1];
    }
}