package solved_problem.leetcode.reorder_data_in_log_files;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String log : logs) {
            String[] split = log.split(" ");
            String data = split[1];
            if (Character.isDigit(data.charAt(0))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        letters.sort((a, b) -> {
            String[] aSplit = a.split(" ",2);
            String[] bSplit = b.split(" ", 2);

            if (aSplit[1].compareTo(bSplit[1]) == 0) {
                return aSplit[0].compareTo(bSplit[0]);
            } else {
                return aSplit[1].compareTo(bSplit[1]);
            }
        });

        letters.addAll(digits);
        return letters.toArray(new String[0]);
    }

}
