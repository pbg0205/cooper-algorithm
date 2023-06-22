package solved_problem.baekjoon.마이너스_2진수_2089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();

        int number = Integer.parseInt(reader.readLine());

        if (number == 0) {
            System.out.println(0);
            return;
        }

        while (number != 1) {
            builder.append(Math.abs(number % (-2)));
            number = (int) Math.ceil((double) number / (-2));
        }

        builder.append(number);

        System.out.println(builder.reverse());
        reader.close();
    }

}

/**
 * -13 = -2 * 7 + 1
 *   7 = -2 * -3 + 1
 *  -3 = -2 * 2 + 1
 *   2 = -2 * -1 + 0
 *  -1 = -2 * 1 + 1
 */
