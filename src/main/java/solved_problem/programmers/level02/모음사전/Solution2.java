package solved_problem.programmers.level02.모음사전;

import java.util.ArrayList;

/**
 * 1.일반적인 dfs 형태를 띄는 문제 풀이
 * <p>
 * (1) 종료 조건 -> 2. 비즈니스 로직 (정형화된 방식이 더욱 풀기 유연한 것 같음)
 * <p/>
 * 2. 시간 복잡도
 * <p>
 * (1) 실제 시간 복잡도 O(n) = dfs (O(1)) * indexOf(O(n)) => 만약 시간 복잡도를 줄이고 싶다면 Map 을 사용하는 방식으로 변경 가능
 * <p>
 * - 최대 5번 까지만 재귀를 호출할 수 있기 때문에 모음(vowel)의 갯수가 정해져 있어서 상수 값이 출력.
 * <p>
 * (2) 잘못된 생각 : O(n^5) => n 이 제한적이기 때문에 문제를 통과(만약 n 이 커진다면 해결할 수 없을 수가 있다. (X)
 * <p/>
 */
class Solution2 {

    private static final char[] VOWELS = "AEIOU".toCharArray();

    public int solution(String word) {
        ArrayList<String> words = new ArrayList<>();
        dfs("", words);
        return words.indexOf(word);
    }

    private void dfs(String currentWord, ArrayList<String> words) {
        if (currentWord.length() > 5) {
            return;
        }
        words.add(currentWord);

        for (char vowel : VOWELS) {
            dfs(currentWord + vowel, words);
        }

    }

}
