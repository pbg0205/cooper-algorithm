package solved_problem.leetcode.search_a_2d_matrix_ii;

/**
 * - Runtime: 4 ms, faster than 100.00% of Java
 * - Memory Usage: 44.6 MB, less than 67.32% of Java
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while ((row <= matrix.length - 1) && (col >= 0)) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (matrix[row][col] > target) {
                col -= 1;
                continue;
            }

            if (matrix[row][col] < target) {
                row += 1;
            }
        }
        return false;
    }
}
