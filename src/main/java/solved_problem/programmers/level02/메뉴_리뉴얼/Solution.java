package solved_problem.programmers.level02.메뉴_리뉴얼;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> solution(String[] orders, int[] course) {
        Map<Integer, Map<String, Integer>> menuCountMap = initCourseCountMap(course);

        // 1. 코스의 메뉴 구성 수에 맞는 코스 후보군을 조합(combination) 을 통해 구한다. (by. backTracking)
        for (String order : orders) {
            for (int courseCount : course) {
                if (order.length() < courseCount) {
                    continue;
                }

                String[] orderMenu = order.split("");
                Arrays.sort(orderMenu);
                combination(orderMenu, new String[courseCount], 0, 0, courseCount,
                        new boolean[order.length()], menuCountMap);
            }
        }

        // 2. 같은 메뉴 구성 수의 후보군 중, 주문 수가 가장 많은 코스를 선정한다.
        List<String> answerList = new ArrayList<>();
        for (int eachCourseCount : course) {
            Map<String, Integer> eachCourseCountMap = menuCountMap.get(eachCourseCount);
            List<Integer> courseCounts = new ArrayList<>(eachCourseCountMap.values());
            int maxCount = Integer.MIN_VALUE;

            for (int courseCount : courseCounts) {
                maxCount = Math.max(maxCount, courseCount);
            }

            for (Map.Entry<String, Integer> eachCourseCountEntry : eachCourseCountMap.entrySet()) {
                String courseMenu = eachCourseCountEntry.getKey();
                int selectedCount = eachCourseCountEntry.getValue();

                if (selectedCount == maxCount && selectedCount >= 2) {
                    answerList.add(courseMenu);
                }
            }
        }

        Collections.sort(answerList);

        return answerList;
    }

    private static Map<Integer, Map<String, Integer>> initCourseCountMap(int[] course) {
        Map<Integer, Map<String, Integer>> courseCountMap = new HashMap<>();
        for (int eachCourse : course) {
            courseCountMap.put(eachCourse, new HashMap<>());
        }
        return courseCountMap;
    }

    private void combination(String[] orderMenu,
                             String[] courseCandidate,
                             int depth,
                             int startIdx,
                             int courseDepth,
                             boolean[] visited,
                             Map<Integer, Map<String, Integer>> menuCountMap) {
        if (depth == courseDepth) {
            Map<String, Integer> courseCountMap = menuCountMap.get(courseDepth);
            String candidateMenu = String.join("", courseCandidate);
            int courseCount = courseCountMap.getOrDefault(candidateMenu, 0);
            courseCountMap.put(candidateMenu, courseCount + 1);
            return;
        }

        for (int idx = startIdx; idx < orderMenu.length; idx++) {
            if (!visited[idx]) {
                visited[idx] = true;
                courseCandidate[depth] = orderMenu[idx];
                combination(orderMenu, courseCandidate, depth + 1, idx + 1, courseDepth, visited, menuCountMap);
                visited[idx] = false;
            }
        }
    }
}
