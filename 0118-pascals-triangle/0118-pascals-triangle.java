class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> previousRow = null;
        for (int r = 1; r <= numRows; r++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(r, 1));
            for (int c = 1; c < row.size() - 1; c++) {
                row.set(c, previousRow.get(c - 1) + previousRow.get(c));
            }
            result.add(row);
            previousRow = row;
        }
        return result;
    }
}