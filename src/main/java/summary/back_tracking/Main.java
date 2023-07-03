package summary.back_tracking;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> answers = BackTrackingUtils.permutation(List.of(2, 3, 5, 7), 2);
        for (List<Integer> answer : answers) {
            System.out.println(answer);
        }

        System.out.println("-----------------");

        List<List<Integer>> answers2 = BackTrackingUtils.permutation(new int[]{2, 3, 5, 7}, 2);
        for (List<Integer> answer2 : answers2) {
            System.out.println(answer2);
        }

        System.out.println("-----------------");
        List<List<Integer>> answers3 = BackTrackingUtils.combination(List.of(2, 3, 5, 7), 2);
        for (List<Integer> answer3 : answers3) {
            System.out.println(answer3);
        }
    }


}
