package solved_problem.programmers.level02.행렬의_곱셈;

class Solution {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int rowSize = arr1.length;
        int colSize = arr2[0].length;
        int[][] answer = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            int col = 0;
            for (int colCount = col; colCount < colSize; colCount++) {
                answer[row][col] += multiplyMatrix(arr1[row], arr2, col);
                col++;
            }
        }

        return answer;
    }

    private int multiplyMatrix(int[] arr1, int[][] arr2, int arr2Col) {
        int answer = 0;
        for (int idx = 0; idx < arr1.length; idx++) {
            answer += arr1[idx] * arr2[idx][arr2Col];
        }
        return answer;
    }

}
