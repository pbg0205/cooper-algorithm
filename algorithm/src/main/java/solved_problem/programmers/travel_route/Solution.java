package solved_problem.programmers.travel_route;

import java.util.ArrayList;
import java.util.List;

class Solution {

    boolean[] visited;
    List<String> answerList = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        answerList.sort(String::compareToIgnoreCase);

        return answerList.get(0).split(" ");
    }

    private void dfs(int count, String start, String answer, String[][] tickets) {
        if (count == tickets.length) {
            answerList.add(answer);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {

            if (!visited[i] && start.equals(tickets[i][0])) {
                visited[i] = true;
                String nextTicket = tickets[i][1];
                dfs(count + 1, nextTicket, answer + " " + nextTicket, tickets);
                visited[i] = false;
            }
        }
    }
}
