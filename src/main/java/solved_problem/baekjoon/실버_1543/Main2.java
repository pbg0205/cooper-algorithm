package solved_problem.baekjoon.실버_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [완전 탐색을 이용한 문제 풀이]
 * <p>
 * 1. time complexity : O(MN)
 * <p>
 * 문자열을 확인하는 횟수 : M
 * <p>
 * 단어 검사 시간 복잡도 : N
 */
class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String document = reader.readLine();
        String searchingWord = reader.readLine();

        int count = 0;

        for (int idx = 0; idx < document.length() - searchingWord.length() + 1; idx++) {
            if (document.charAt(idx) != searchingWord.charAt(0)) {
                continue;
            }

            if (matchesWord(document, searchingWord, idx)) {
                idx += searchingWord.length() - 1;
                count++;
            }

        }

        System.out.println(count);

        reader.close();
    }

    private static boolean matchesWord(String document, String searchingWord, int currentIdx) {
        int startIdx = currentIdx;
        int endIdx = (currentIdx + searchingWord.length()) >= document.length() ?
                document.length() :
                currentIdx + searchingWord.length();

        return document.substring(startIdx, endIdx).equals(searchingWord);
    }

}
