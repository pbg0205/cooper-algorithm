package solved_problem.baekjoon._8진수2진수_1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger number = new BigInteger(reader.readLine(), 8);
        String binaryRadixNum = number.toString(2);

        System.out.println(binaryRadixNum);

        reader.close();
    }

}
