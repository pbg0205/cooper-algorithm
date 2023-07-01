package solved_problem.programmers.level02.소수_찾기;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    private static boolean[] isPrime = new boolean[10_000_001];
    private static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        char[] charArr = numbers.toCharArray();
        for (int i = 2; i * i <= 10000000; i++) {
            for (int j = i * i; j <= 10000000; j += i) {
                isPrime[j] = false;
            }
        }

        int n = numbers.length();
        int[] data = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int r = 1; r <= n; r++) {
            permutation(n, r, 0, charArr, visited, data);
        }

        return set.size();
    }

    private void permutation(int n, int r, int depth, char[] charArr, boolean[] visited, int[] data) {
        if (depth == r) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < r; i++) {
                tmp.append(charArr[data[i]]);
            }

            int number = Integer.parseInt(tmp.toString());
            if (isPrime[number]) {
                set.add(number);
            }
            return;
        }
        for (int idx = 0; idx < n; idx++) {
            if (!visited[idx]) {
                visited[idx] = true;
                data[depth] = idx;
                permutation(n, r, depth + 1, charArr, visited, data);
                visited[idx] = false;
            }
        }
    }
}
