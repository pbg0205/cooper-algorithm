package solved_problem.leetcode.queue_reconstruction_by_height;

import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        sortByHeightAndNumberOfTallerPeople(people);
        List<int[]> resultList = sortByNumberOfTallerPeople(people);
        return resultList.toArray(new int[0][]);
    }

    private List<int[]> sortByNumberOfTallerPeople(int[][] people) {
        List<int[]> resultList = new ArrayList<>();

        for (int[] person : people) {
            resultList.add(person[1], person);
        }

        return resultList;
    }

    private void sortByHeightAndNumberOfTallerPeople(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
    }
}
