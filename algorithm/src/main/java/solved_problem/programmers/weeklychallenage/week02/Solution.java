package solved_problem.programmers.weeklychallenage.week02;

class Solution {
    public String solution(int[][] scores) {
        double[] averages = getAverages(scores);
        return getGradesByAverages(averages);
    }

    private String getGradesByAverages(double[] averages) {
        StringBuilder gradesBuilder = new StringBuilder();
        for (double average : averages) {
            if (average >= 90) {
                gradesBuilder.append("A");
            }else if (80 <= average && average < 90) {
                gradesBuilder.append("B");
            }else if (70 <= average && average < 80) {
                gradesBuilder.append("C");
            }else if (50 <= average && average < 70) {
                gradesBuilder.append("D");
            }else {
                gradesBuilder.append("F");
            }
        }
        return gradesBuilder.toString();
    }

    private double[] getAverages(int[][] scores) {
        double[] averages = new double[scores.length];

        for (int i = 0; i < scores.length; i++) {
            double selfEvaluation = scores[i][i];
            double min = Integer.MAX_VALUE;
            double minCount = 0;
            double max = Integer.MIN_VALUE;
            double maxCount = 0;
            double sum = 0;

            for (int j = 0; j < scores.length; j++) {
                if (min > scores[j][i]) {
                    min = scores[j][i];
                    minCount = 0;
                }

                if (min == scores[j][i]) {
                    minCount++;
                }

                if (max < scores[j][i]) {
                    max = scores[j][i];
                    maxCount = 0;
                }

                if (max == scores[j][i]) {
                    maxCount++;
                }
                sum += scores[j][i];
            }


            if (selfEvaluation == min && minCount == 1) {
                sum -= selfEvaluation;
                averages[i] = sum / (scores.length - 1);
                continue;
            }

            if (selfEvaluation == max && maxCount == 1) {
                sum -= selfEvaluation;
                averages[i] = sum / (scores.length - 1);
                continue;
            }

            averages[i] = sum / (scores.length);

        }
        return averages;
    }
}
