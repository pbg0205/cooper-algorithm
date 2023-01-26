package solved_problem.programmers.level02.이모티콘_할인행사;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 1. 10, 20, 30, 40 이 랜덤이기 때문에 중복 조합을 구하기 위해 BFS 를 선언하고 조합 값을 Stack 에 담아서 연산.
 * 2. 나머지는 문제 요구사항에 맞춰서 문제 해결
 */
class Solution {

    private int maxEmoticonPlus =0;
    private int maxSales = 0;

    public List<Integer> solution(int[][] users, int[] emoticons) {
        List<Integer> answer = new ArrayList<>();

        LinkedList<Integer> salesRates = new LinkedList<>();
        dfs(salesRates, users, emoticons);

        answer.add(maxEmoticonPlus);
        answer.add(maxSales);

        return answer;
    }

    private void dfs(LinkedList<Integer> salesRates, int[][] users, int[] emoticons) {
        if (salesRates.size() == emoticons.length) {
            calculate(salesRates, users, emoticons);
            return;
        }

        // 중복 조합을 이용
        for (int saleRate = 10; saleRate <= 40; saleRate += 10) {
            salesRates.addLast(saleRate);
            dfs(salesRates, users, emoticons);
            salesRates.removeLast();
        }
    }

    private void calculate(LinkedList<Integer> salesRates, int[][] users, int[] emoticons) {
        int emoticonPlus = 0;
        int sales = 0;

        for (int[] user : users) {
            int temp = 0;

            for (int i = 0; i < salesRates.size(); i++) {
                if (user[0] > salesRates.get(i)) {
                    continue;
                }

                temp += (emoticons[i] / 100) * (100 - salesRates.get(i));
            }

            if (temp >= user[1]) {
                emoticonPlus++;
            } else {
                sales += temp;
            }
        }

        if (maxEmoticonPlus > emoticonPlus) {
            return;
        }

        if (maxEmoticonPlus == emoticonPlus && maxSales >= sales) {
            return;
        }

        maxEmoticonPlus = emoticonPlus;
        maxSales = sales;
    }

}
