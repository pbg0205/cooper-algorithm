package solved_problem.programmers.level01.완주하지_못한_선수;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {

        Map<String,Integer> remainingMap = new HashMap<>();

        for(String athlete : participant){
            remainingMap.put(athlete, remainingMap.getOrDefault(athlete,0) + 1);
        }

        for(String athlete : completion){
            if(remainingMap.containsKey(athlete))
                remainingMap.put(athlete, remainingMap.get(athlete) - 1);
        }

        for(String confirm : remainingMap.keySet()){
            if(remainingMap.get(confirm) == 0) {
                continue;
            }
            return confirm;
        }

        return "";
    }

}
