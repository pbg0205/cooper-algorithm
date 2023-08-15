package solved_problem.baekjoon.막대기_1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stickLen = Integer.parseInt(br.readLine());
        int index = 6;
        int count = 0;

        while(index >= 0){
            if(stickLen - (1 << index) >= 0){
                stickLen -= (1 << index);
                count++;
            }

            index--;
        }

        System.out.println(count);

        br.close();
    }
}
