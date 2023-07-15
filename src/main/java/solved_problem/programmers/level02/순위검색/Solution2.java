package solved_problem.programmers.level02.순위검색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution2 {

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoreMap(info);

        System.out.println(scoresMap);

        int[] answer = new int[query.length];
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = count(query[idx], scoresMap);
        }

        return answer;
    }

    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");
        String key = Arrays.stream(Arrays.copyOfRange(tokens, 0, tokens.length - 1)).collect(Collectors.joining());

        if (!scoresMap.containsKey(key)) {
            return 0;
        }

        List<Integer> scores = scoresMap.get(key);
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }

    // 반족하는 범위의 최소 값을 구하는 경우
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; // 자료형을 초과하지 않는 연산

            if (scores.get(mid) < score) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return start;
    }

    private Map<String, List<Integer>> buildScoreMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            initScoreMap(0, "", tokens, scoresMap, score);
        }

        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }

        return scoresMap;
    }

    private void initScoreMap(int index, String prefix, String[] tokens, Map<String, List<Integer>> scoresMap, int score) {
        if (index == tokens.length - 1) {
            scoresMap.putIfAbsent(prefix, new ArrayList<>());
            scoresMap.get(prefix).add(score);
            return;
        }

        initScoreMap(index + 1, prefix + tokens[index], tokens, scoresMap, score);
        initScoreMap(index + 1, prefix + "-", tokens, scoresMap, score);
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };
        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };
        int[] solution = solution2.solution(info, query);
        for (int i : solution) {
            System.out.println(i);
        }

    }
}
