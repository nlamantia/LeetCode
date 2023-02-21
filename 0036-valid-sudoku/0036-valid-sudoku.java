class Solution {
    private static final int NUM_ROWS = 9;
    private static final int NUM_COLS = 9;
    private static final int NUM_BLOCKS = 9;
    private static final int BLOCKS_PER_ROW = 3;
    
    private Map<Integer, Set<Integer>> rowDigits = integerSetMap(NUM_ROWS);
    private Map<Integer, Set<Integer>> colDigits = integerSetMap(NUM_COLS);
    private Map<Integer, Set<Integer>> blockDigits = integerSetMap(NUM_BLOCKS);
    
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < NUM_ROWS; r++) {
            for (int c = 0; c < NUM_COLS; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                
                int digit = Character.getNumericValue(board[r][c]);
                if (isInvalidCell(r, c, digit)) {
                    return false;
                }
                
                rowDigits.get(r).add(digit);
                colDigits.get(c).add(digit);
                blockDigits.get(getBlockNumber(r, c)).add(digit);
            }
        }
        
        return true;
    }
    
    private boolean isInvalidCell(int r, int c, int digit) {
        return rowDigits.get(r).contains(digit) 
            || colDigits.get(c).contains(digit)
            || blockDigits.get(getBlockNumber(r, c)).contains(digit);
    }
    
    private int getBlockNumber(int r, int c) {
        return (r / BLOCKS_PER_ROW) * BLOCKS_PER_ROW + (c / BLOCKS_PER_ROW);
    }
    
    private static Map<Integer, Set<Integer>> integerSetMap(int size) {
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for (int i = 0; i < size; i++) {
            result.put(i, new HashSet<>());
        }
        return result;
    }
}