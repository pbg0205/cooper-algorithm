package solved_problem.baekjoon.N과M_4_15652;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * @link https://www.acmicpc.net/problem/15652
 * // 4 2
 * 1 1
 * 1 2
 * 1 3
 * 1 4
 * 2 2
 * 2 3
 * 2 4
 * 3 3
 * 3 4
 * 4 4
 *
 */
class Main {

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(BR.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        LinkedList<Integer> numbers = new LinkedList<>();
        combination(numbers, N, M, 1);

        BW.flush();
        BW.close();
        BR.close();
    }

    private static void combination(LinkedList<Integer> numbers, int n, int m, int now) throws IOException {
        if (numbers.size() == m) {
            print(numbers);
            return;
        }
        for (int index = now; index <= n; index++) {
            numbers.addLast(index);
            combination(numbers, n, m, index);
            numbers.removeLast();
        }
    }

    private static void print(LinkedList<Integer> numbers) throws IOException {
        String numbersStr = numbers.stream().map(String::valueOf).collect(Collectors.joining(" ", "", "\n"));
        BW.write(numbersStr);
    }

}
