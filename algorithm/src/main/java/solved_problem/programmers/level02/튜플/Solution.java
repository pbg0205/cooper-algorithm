package solved_problem.programmers.level02.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length() - 2).replace("},{", "-");

        String[] tempArr = s.split("-");
        Arrays.sort(tempArr, (a, b) -> Integer.compare(a.length(), b.length()));

        List<Integer> list = new ArrayList<>();
        for (String temp : tempArr) {
            String[] values = temp.split(",");

            for (String value : values) {
                int number = Integer.valueOf(value);

                if (!list.contains(number)) {
                    list.add(number);
                }
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
