package solved_problem.baekjoon.배열_돌리기3_16935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int r = Integer.parseInt(tokenizer.nextToken());

        int[][] arr = new int[n][m];
        for (int row = 0; row < n; row++) {
            String input = reader.readLine();
            tokenizer = new StringTokenizer(input);
            int col = 0;
            while (tokenizer.hasMoreTokens()) {
                arr[row][col++] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());

        while (tokenizer.hasMoreTokens()) {
            int operationNumber = Integer.parseInt(tokenizer.nextToken());
            if (operationNumber == 1) {
                arr = switchUpAndDown(arr);
            } else if (operationNumber == 2) {
                arr = switchLeftAndRight(arr);
            } else if (operationNumber == 3) {
                arr = switchRight90Degree(arr);
            } else if (operationNumber == 4) {
                arr = switchLeft90Degree(arr);
            } else if (operationNumber == 5) {
                arr = switchRightQuarter(arr);
            } else if (operationNumber == 6) {
                arr = switchLeftQuarter(arr);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                builder.append(arr[row][col]).append(" ");
            }
            builder.append("\n");
        }

        System.out.println(builder);

        reader.close();
    }

    private static int[][] switchUpAndDown(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;

        int[][] answer = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                answer[(rowSize - 1) - row][col] = arr[row][col];
            }
        }

        return answer;
    }

    private static int[][] switchLeftAndRight(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;

        int[][] answer = new int[rowSize][colSize];

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                answer[row][(colSize - 1) - col] = arr[row][col];
            }
        }

        return answer;
    }

    private static int[][] switchRight90Degree(int[][] arr) {
        int arrRowSize = arr.length;
        int arrColSize = arr[0].length;
        int[][] answer = new int[arrColSize][arrRowSize];

        int answerCol = arrRowSize - 1;
        for (int row = 0; row < arrRowSize; row++) {
            for (int col = 0; col < arrColSize; col++) {
                answer[col][answerCol] = arr[row][col];
            }
            answerCol--;
        }

        return answer;
    }

    private static int[][] switchLeft90Degree(int[][] arr) {
        int arrRowSize = arr.length;
        int arrColSize = arr[0].length;
        int[][] answer = new int[arrColSize][arrRowSize];

        for (int row = 0; row < arrRowSize; row++) {
            for (int col = 0; col < arrColSize; col++) {
                answer[arrColSize - col - 1][row] = arr[row][col];
            }
        }

        return answer;
    }

    private static int[][] switchRightQuarter(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        int rowMid = rowSize / 2;
        int colMid = colSize / 2;

        int[][] answer = new int[rowSize][colSize];

        for (int row = 0; row < rowMid; row++) {
            for (int col = 0; col < colMid; col++) {
                answer[row][colMid + col] = arr[row][col];
            }
        }

        for (int row = 0; row < rowMid; row++) {
            for (int col = colMid; col < colSize; col++) {
                answer[rowMid + row][col] = arr[row][col];
            }
        }

        for (int row = rowMid; row < rowSize; row++) {
            int answerCol = 0;
            for (int col = colMid; col < colSize; col++, answerCol++) {
                answer[row][answerCol] = arr[row][col];
            }
        }

        int answerRow = 0;
        for (int row = rowMid; row < rowSize; row++, answerRow++) {
            for (int col = 0; col < colMid; col++) {
                answer[answerRow][col] = arr[row][col];
            }
        }

        return answer;
    }

    private static int[][] switchLeftQuarter(int[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        int rowMid = rowSize / 2;
        int colMid = colSize / 2;

        int[][] answer = new int[rowSize][colSize];

        for (int row = 0; row < rowMid; row++) {
            for (int col = 0; col < colMid; col++) {
                answer[rowMid + row][col] = arr[row][col];
            }
        }

        for (int row = rowMid; row < rowSize; row++) {
            for (int col = 0; col < colMid; col++) {
                answer[row][colMid + col] = arr[row][col];
            }
        }

        int answerRow = 0;
        for (int row = rowMid; row < rowSize; row++, answerRow++) {
            for (int col = colMid; col < colSize; col++) {
                answer[answerRow][col] = arr[row][col];
            }
        }

        for (int row = 0; row < rowMid; row++) {
            int answerCol = 0;
            for (int col = colMid; col < colSize; col++, answerCol++) {
                answer[row][answerCol] = arr[row][col];
            }
        }

        return answer;
    }

}
