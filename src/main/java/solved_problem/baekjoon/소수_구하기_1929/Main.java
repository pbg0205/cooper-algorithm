package solved_problem.baekjoon.소수_구하기_1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static boolean[] is_prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startNum = Integer.parseInt(st.nextToken());
        int endNum = Integer.parseInt(st.nextToken());

        is_prime = new boolean[endNum + 1];
        Arrays.fill(is_prime, true);
        getPrimeNum();

        StringBuilder sb = new StringBuilder();
        for(int i = startNum; i <= endNum; i++) {
            if(is_prime[i]) sb.append(i + "\n");
        }

        System.out.println(sb.toString());

        br.close();
    }

    public static void getPrimeNum() {
        is_prime[1] = false;
        //소수의 배수는 에라테네스의 체에서 값에서 배제시키는 역할을 한다.
        for (int inpust_num = 2; inpust_num < is_prime.length; inpust_num++) {
            for (int mul_num = 2; inpust_num * mul_num < is_prime.length; mul_num++) {
                is_prime[inpust_num * mul_num] = false;
            }
        }
    }
}
