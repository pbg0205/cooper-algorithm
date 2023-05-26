package solved_problem.programmers.level01.추억_점수;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int index = 0; index < name.length; index++) {
            scoreMap.put(name[index], yearning[index]);
        }

        int answerIndex = 0;
        for (String[] photoNames : photo) {
            for (String photoName : photoNames) {
                answer[answerIndex] += scoreMap.getOrDefault(photoName, 0);
            }
            answerIndex++;
        }

        return answer;
    }

}
