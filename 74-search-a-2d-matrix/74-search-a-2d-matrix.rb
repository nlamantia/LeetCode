# @param {Integer[][]} matrix
# @param {Integer} target
# @return {Boolean}
#
# O(m + n) time | O(1) space
# where m is the number of rows and n is the number of columns in the matrix
def search_matrix(matrix, target)
    row, col = [0, matrix[0].length - 1]
    while row < matrix.length && col >= 0
        return true if matrix[row][col] == target
        if target > matrix[row][col]
            row += 1
        else
            col -= 1
        end
    end
    false
end