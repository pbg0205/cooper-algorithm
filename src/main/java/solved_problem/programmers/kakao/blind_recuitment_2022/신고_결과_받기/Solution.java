package solved_problem.programmers.kakao.blind_recuitment_2022.신고_결과_받기;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportIdIndexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportIdIndexMap.put(id_list[i], i);
        }

        Map<String, Integer> reportedIdCountMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportedIdCountMap.put(id_list[i], 0);
        }

        Map<String, Set<Integer>> reportIndexListMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportIndexListMap.put(id_list[i], new HashSet<>());
        }

        for (int i = 0; i < report.length; i++) {
            String[] reportContent = report[i].split(" ");
            String reportId = reportContent[0];
            String reportedId = reportContent[1];

            Set<Integer> reportIndexes = reportIndexListMap.get(reportedId);
            int reportIdIndex = reportIdIndexMap.get(reportId);
            if (!reportIndexes.contains(reportIdIndex)) {
                int reportedCount = reportedIdCountMap.getOrDefault(reportedId, 0);
                reportedIdCountMap.put(reportedId, reportedCount + 1);
                reportIndexes.add(reportIdIndex);
            }
        }

        int[] answer = new int[id_list.length];
        for (Map.Entry<String, Integer> reportedIdEntry : reportedIdCountMap.entrySet()) {
            int reportedCount = reportedIdEntry.getValue();
            if (reportedCount >= k) {
                String reportedId = reportedIdEntry.getKey();
                Set<Integer> reportIndexes = reportIndexListMap.get(reportedId);
                for (Integer reportIndex : reportIndexes) {
                    answer[reportIndex]++;
                }
            }
        }

        return answer;
    }

}

/**
 * 테스트 1 〉  통과 (0.28ms, 76.4MB)
 * 테스트 2 〉  통과 (0.28ms, 88.2MB)
 * 테스트 3 〉  통과 (154.59ms, 171MB)
 * 테스트 4 〉  통과 (0.42ms, 75.5MB)
 * 테스트 5 〉  통과 (0.46ms, 71.1MB)
 * 테스트 6 〉  통과 (3.62ms, 81.2MB)
 * 테스트 7 〉  통과 (7.47ms, 80MB)
 * 테스트 8 〉  통과 (10.52ms, 92.9MB)
 * 테스트 9 〉  통과 (96.84ms, 135MB)
 * 테스트 10 〉 통과 (115.48ms, 130MB)
 * 테스트 11 〉 통과 (199.00ms, 171MB)
 * 테스트 12 〉 통과 (1.47ms, 77.9MB)
 * 테스트 13 〉 통과 (2.01ms, 79.2MB)
 * 테스트 14 〉 통과 (89.60ms, 122MB)
 * 테스트 15 〉 통과 (126.38ms, 156MB)
 * 테스트 16 〉 통과 (1.43ms, 76.1MB)
 * 테스트 17 〉 통과 (1.26ms, 78.5MB)
 * 테스트 18 〉 통과 (2.21ms, 79.5MB)
 * 테스트 19 〉 통과 (6.02ms, 80.4MB)
 * 테스트 20 〉 통과 (105.78ms, 118MB)
 * 테스트 21 〉 통과 (186.97ms, 153MB)
 * 테스트 22 〉 통과 (0.25ms, 69.4MB)
 * 테스트 23 〉 통과 (0.26ms, 86.7MB)
 * 테스트 24 〉 통과 (0.20ms, 74.6MB)
 */
