package solved_problem.baekjoon.실버_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * [java.util.regex 를 이용한 풀이]
 * <p>
 * 1. time complexity : O(MN)
 * <p>
 * 문자열을 확인하는 횟수 : M
 * <p>
 * 단어 검사 시간 복잡도 : N
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String document = reader.readLine();
        String searchingWord = reader.readLine();

        System.out.println(countSearchingWord(document, searchingWord));;

        reader.close();
    }

    private static int countSearchingWord(CharSequence document, String searchingWord) {
        Pattern pattern = Pattern.compile(searchingWord);
        Matcher matcher = pattern.matcher(document);

        int count = 0;
        while (matcher.find()) {
            count++;
        }

        return count;
    }

}
