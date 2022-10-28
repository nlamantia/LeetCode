class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        char[][] grid = new char[numRows][s.length()];
        
        int i = 0, col = 0, row = 0;
        while (i < s.length()) {
            for (row = 0; row < numRows && i < s.length(); row++) {
                grid[row][col] = s.charAt(i++);
            }
            
            col++;
            for (row -= 2; row > 0 && i < s.length(); row--) {
                grid[row][col++] = s.charAt(i++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char[] charRow : grid) {
            for (char c : charRow) {
                if (c != 0) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}