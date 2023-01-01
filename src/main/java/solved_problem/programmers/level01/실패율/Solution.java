package solved_problem.programmers.level01.실패율;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Integer> stageMap = new HashMap<>();
        List<Stage> stageList = new ArrayList<>();


        for (int stage : stages) {
            if(stageMap.containsKey(stage)) {
                stageMap.put(stage, stageMap.get(stage) + 1);
            }else {
                stageMap.put(stage, 1);
            }
        }

        for (int i = 1; i <= N; i++) {
            int challenger = 0;
            int clearedMember = 0;

            for (Map.Entry<Integer, Integer> entry : stageMap.entrySet()) {
                int stage = entry.getKey();
                int value = entry.getValue();

                if (i == stage) {
                    challenger += value;
                }

                if (i <= stage) {
                    clearedMember += value;
                }
            }

            if (challenger == 0) {
                stageList.add(new Stage(i, 0));
            } else {
                stageList.add(new Stage(i, (double) challenger / clearedMember));
            }
        }

        stageList.sort((o1, o2) -> {
            if (o1.failRatio != o2.failRatio) {
                return -Double.compare(o1.failRatio, o2.failRatio);
            } else {
                return Integer.compare(o1.no, o2.no);
            }
        });

        for (Stage stage : stageList) {
            System.out.println(stage.no + " " + stage.failRatio);
        }

        return stageList.stream()
                .mapToInt(stage -> stage.no)
                .toArray();
    }

    class Stage {
        private int no;
        private double failRatio;

        public Stage(int no, double failRatio) {
            this.no = no;
            this.failRatio = failRatio;
        }
    }
}