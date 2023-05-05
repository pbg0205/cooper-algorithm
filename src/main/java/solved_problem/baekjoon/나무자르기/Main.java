package solved_problem.baekjoon.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] treeHeight = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < n; idx++) {
            treeHeight[idx] = Long.parseLong(st.nextToken());
        }

        long pl = 0;
        long pr = initPr(treeHeight);

        while (pl <= pr) {
            long pc = (pl + pr) / 2;
            long sum = calculateSum(treeHeight, pc);

            System.out.println("pl = " + pl);
            System.out.println("pr = " + pr);

            if (sum >= m) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        }

        System.out.println(pr);
    }

    private static long calculateSum(long[] treeHeight, long pivot) {
        long sum = 0L;

        for (long height : treeHeight) {
            if (height < pivot) {
                continue;
            }
            sum += height - pivot;
        }

        return sum;
    }

    private static long initPr(long[] treeHeight) {
        long pr = -1;
        for (long height : treeHeight) {
            if (height > pr) {
                pr = height;
            }
        }

        return pr;
    }

}
