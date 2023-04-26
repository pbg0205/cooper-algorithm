package solved_problem.programmers.level03.하노이의_탑;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<int[]> solution(int n) {
        ArrayList<int[]> result = new ArrayList<>();
        hanoi(n, 1, 3, result);
        return result;
    }

    private void hanoi(int n, int from, int to, ArrayList<int[]> result) {
        if (n == 1) {
            result.add(new int[]{from, to});
            return;
        }

        int empty = 6 - from - to;

        hanoi(n - 1, from, empty, result);
        hanoi(1, from, to, result);
        hanoi(n - 1, empty, to, result);
    }

}
