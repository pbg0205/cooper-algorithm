package solved_problem.baekjoon.단어_정렬_1181;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int N = Integer.parseInt(SCANNER.nextLine());

        Set<String> wordSet = addInputs(N);

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length()) { // 길이가 같을 경우
                    return s1.compareTo(s2); // 사전식 정렬
                }

                /**
                 * - 왼쪽이 더 크면 순서가 바뀌기 때문에 오름차순 정렬
                 * - return value < 0 : 순서 안바꿈
                 * - return value > 0 : 순서 바꿈
                 */
                return s1.length() - s2.length();
            }
        };

        List<String> words = new ArrayList<>(wordSet);
        words.sort(stringComparator);

        printWords(words);
    }

    private static Set<String> addInputs(int N) {
        Set<String> wordSet = new HashSet<>();
        for (int testCase = 0; testCase < N; testCase++) {
            wordSet.add(SCANNER.nextLine());
        }
        return wordSet;
    }

    private static void printWords(List<String> words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            stringBuilder.append(word).append("\n");
        }

        System.out.println(stringBuilder);
    }

}
