package solved_problem.programmers.level01.달리기_경주;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playerRankMap = new HashMap<>();
        Map<Integer, String> rankPlayerMap = new HashMap<>();

        for (int rank = 0; rank < players.length; rank++) {
            playerRankMap.put(players[rank], rank);
            rankPlayerMap.put(rank, players[rank]);
        }

        for (String calling : callings) {
            int rank = playerRankMap.get(calling);
            String player = rankPlayerMap.get(rank);

            int upperRank = rank - 1;
            String upperRankPlayer = rankPlayerMap.get(upperRank);
            swapPlayerAndRank(player, rank, upperRankPlayer, upperRank, playerRankMap, rankPlayerMap);

        }

        List<Integer> rankList = rankPlayerMap.keySet().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        List<String> answer = new ArrayList<>();
        for (Integer currentRank : rankList) {
            answer.add(rankPlayerMap.get(currentRank));
        }

        return answer.stream().toArray(String[]::new);
    }

    private void swapPlayerAndRank(
            String player, int rank,
            String upperRankPlayer, int upperRank,
            Map<String, Integer> playerRankMap,
            Map<Integer, String> rankPlayerMap
    ) {
        playerRankMap.put(upperRankPlayer, rank);
        rankPlayerMap.put(rank, upperRankPlayer);

        playerRankMap.put(player, upperRank);
        rankPlayerMap.put(upperRank, player);
    }

}
