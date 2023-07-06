package solved_problem.baekjoon.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int n = Integer.parseInt(reader.readLine());
        int[] nNumbers = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            nNumbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int m = Integer.parseInt(reader.readLine());
        int[] mNumbers = new int[m];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            mNumbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(nNumbers);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mNumbers.length; i++) {
            int result = (Arrays.binarySearch(nNumbers, mNumbers[i]) >= 0) ? 1 : 0;
            builder.append(result).append("\n");
        }

        System.out.println(builder);

        reader.close();
    }

}
