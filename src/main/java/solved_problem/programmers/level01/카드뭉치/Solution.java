package solved_problem.programmers.level01.카드뭉치;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardQueue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cardQueue2 = new LinkedList<>(Arrays.asList(cards2));

        if (isValid(cardQueue1, cardQueue2, goal)) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private boolean isValid(Queue<String> cardQueue1, Queue<String> cardQueue2, String[] goal) {
        for (String word : goal) {
            if (word.equals(cardQueue1.peek())) {
                cardQueue1.poll();
                continue;
            }

            if (word.equals(cardQueue2.peek())) {
                cardQueue2.poll();
                continue;
            }

            return false;
        }

        return true;
    }

}
