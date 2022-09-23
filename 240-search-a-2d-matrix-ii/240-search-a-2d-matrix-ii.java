class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (binarySearch(row, target)) {
                 return true;
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[] row, int target) {
        int start = 0, end = row.length - 1;
        while (start < end - 1) {
            int middle = start + (end - start) / 2;
            if (row[middle] == target) {
                return true;
            } else if (row[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }
        return row[start] == target || row[end] == target;
    }
}