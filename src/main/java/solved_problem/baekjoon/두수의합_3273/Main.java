package solved_problem.baekjoon.두수의합_3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] numberStr = br.readLine().split(" ");
        int[] numbers = new int[numberStr.length];
        int target = Integer.parseInt(br.readLine());

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numberStr[i]);
        }

        Arrays.sort(numbers);

        int leftIdx = 0;
        int rightIdx = numbers.length - 1;
        int count = 0;

        while (leftIdx < rightIdx) {
            int sum = numbers[leftIdx] + numbers[rightIdx];

            if (sum > target) {
                rightIdx--;
            }

            if (sum <= target) {
                leftIdx++;
            }

            if (sum == target) {
                count++;
            }
        }

        System.out.println(count);

        br.close();
    }
}
