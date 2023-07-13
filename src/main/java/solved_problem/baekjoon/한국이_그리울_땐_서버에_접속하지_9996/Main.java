package solved_problem.baekjoon.한국이_그리울_땐_서버에_접속하지_9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String regex = reader.readLine().replaceAll("\\*", "[a-z]*");;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = reader.readLine();
            if (input.matches(regex)) {
                builder.append("DA").append("\n");
                continue;
            }
            builder.append("NE").append("\n");
        }

        System.out.println(builder);

        reader.close();
    }

}
