package solved_problem.programmers.level03.베스트앨범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> soredGenreList = new ArrayList<>(genreMap.keySet());
        soredGenreList.sort((o1, o2) -> genreMap.get(o2).compareTo(genreMap.get(o1)));

        for (String genre : soredGenreList) {
            int firstIndex = 0;
            int secondIndex = 0;

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i]) && plays[i] > max) {
                    max = plays[i];
                    firstIndex = i;
                }
            }

            max = Integer.MIN_VALUE;
            for (int i = 0; i < genres.length; i++) {
                if (genre.equals(genres[i]) && max < plays[i] && i != firstIndex) {
                    max = plays[i];
                    secondIndex = i;
                }
            }

            answerList.add(firstIndex);
            answerList.add(secondIndex);
        }
        return answerList;
    }
}
