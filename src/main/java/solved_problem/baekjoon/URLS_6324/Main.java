package solved_problem.baekjoon.URLS_6324;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    private static final String REGEX = "(http|ftp|gopher)://([\\w.-]+)(?::([0-9]+))?(?:/([\\S]+))?";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        List<String> outputFormats = List.of("Protocol = ", "Host     = ", "Port     = ", "Path     = ");

        for (int i = 0; i < n; i++) {
            writer.write("URL #" + (i + 1) + "\n");

            String input = reader.readLine();
            Matcher matcher = PATTERN.matcher(input);

            if (matcher.find()) {
                for (int j = 0; j < outputFormats.size(); j++) {
                    if (matcher.group(j) != null) {
                        writer.write(outputFormats.get(j) + matcher.group(j) + "\n");
                    } else {
                        writer.write(outputFormats.get(j) + "<default>" + "\n");
                    }
                }
            }
            writer.newLine();
        }

        writer.flush();
        reader.close();
    }

}
