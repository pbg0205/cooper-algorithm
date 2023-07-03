package summary.back_tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 백트래킹을 이용한 순열 로직
 * <br>
 * [DFS]
 * <br>
 * - 깊이 우선 탐색으로 모든 경로를 후보로 탐색하는 과정
 * <br>
 * - 불필요할 것 같은 경로까지 탐색하는 경우도 있어서 비효율적이다.
 * <p/>
 * [BackTracking]
 * <br>
 * - DFS 의 종류 중 하나
 * <br>
 * - 해를 찾아가는 도중, 지금의 경로가 해가 될 것 같지 않으면 되돌아가는 과정
 * <br>
 * - 해가 될 것 같지 않으면 탐색하지 않기 때문에 상대적으로 효율적
 * <p>
 * [대표 문제]
 * - N과 M(5) :
 * - n-queen :  https://www.acmicpc.net/problem/9663
 */
public class BackTrackingUtils {

    private BackTrackingUtils() {
    }

    public static List<List<Integer>> combination(List<Integer> numbers, int r) {
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            visited.add(false);
        }

        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            result.add(-1);
        }

        combinationByList(numbers, r, 0, 0, result, visited, answer);
        return answer;
    }

    private static void combinationByList(List<Integer> numbers,
                                          int r,
                                          int depth,
                                          int startIdx,
                                          List<Integer> result,
                                          List<Boolean> visited,
                                          List<List<Integer>> answer) {
        if (depth == r) {
            answer.add(new ArrayList<>(result));
            return;
        }

        for (int idx = startIdx; idx < numbers.size(); idx++) {
            if (!visited.get(idx)) {
                visited.set(idx, true);
                result.set(depth, numbers.get(idx));
                combinationByList(numbers, r, depth + 1, idx + 1, result, visited, answer);
                visited.set(idx, false);
            }
        }
    }

    /**
     * - list 를 통해서 dfs 를 구현하는 방법: array 보다 전처리 작업이 필요해서 번거로운 것이 단점
     */
    public static List<List<Integer>> permutation(List<Integer> numbers, int r) {
        List<Boolean> visited = new ArrayList<>(numbers.size());
        for (int i = 0; i < numbers.size(); i++) { // 방문 여부를 나타내기 위한 초기화
            visited.add(false);
        }

        List<List<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> tempAnswer = new ArrayList<>();
        for (int i = 0; i < r; i++) { // r 만큼만 추가
            tempAnswer.add(-1);
        }

        permutationByList(numbers, r, 0, tempAnswer, visited, answer);

        return answer;
    }

    /**
     * @param numbers : input number
     * @param r : 조회하고 싶은 데이터 수
     * @param depth : 현재 재귀 깊이
     * @param tempAnswer : 결과 값을 임시 저장
     * @param visited : 방문 여부 체크
     * @param answers : 결과들을 저장하는 역할
     */
    private static void permutationByList(List<Integer> numbers,
                                          int r,
                                          int depth,
                                          List<Integer> tempAnswer,
                                          List<Boolean> visited,
                                          List<List<Integer>> answers) {
        if (depth == r) {
            answers.add(new ArrayList<>(tempAnswer));
            return;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!visited.get(i)) {
                visited.set(i, true);
                tempAnswer.set(depth, numbers.get(i));
                permutationByList(numbers, r, depth + 1, tempAnswer, visited, answers);
                visited.set(i, false);
            }
        }
    }

    /**
     * - array 를 통해서 dfs 를 구현하는 방법: list 보다 전처리 작업이 없어 간단하다
     */
    public static List<List<Integer>> permutation(int[] numbers, int r) {
        boolean[] visited = new boolean[numbers.length];
        int[] tempAnswer = new int[r];
        List<List<Integer>> answer = new ArrayList<>();

        permutationByArray(numbers, r, 0, tempAnswer, visited, answer);

        return answer;
    }

    /**
     * @param numbers : input number
     * @param r : 조회하고 싶은 데이터 수
     * @param depth : 현재 재귀 깊이
     * @param tempAnswer : 결과 값을 임시 저장
     * @param visited : 방문 여부 체크
     * @param answers : 결과들을 저장하는 역할
     */
    private static void permutationByArray(int[] numbers,
                                           int r,
                                           int depth,
                                           int[] tempAnswer,
                                           boolean[] visited,
                                           List<List<Integer>> answers) {
        if (depth == r) {
            List<Integer> newTempAnswer = Arrays.stream(tempAnswer.clone())
                    .boxed()
                    .collect(Collectors.toList());

            answers.add(newTempAnswer);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tempAnswer[depth] = numbers[i];
                permutationByArray(numbers, r, depth + 1, tempAnswer, visited, answers);
                visited[i] = false;
            }
        }
    }

}
