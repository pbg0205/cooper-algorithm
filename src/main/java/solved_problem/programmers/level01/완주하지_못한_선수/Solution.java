package solved_problem.programmers.level01.완주하지_못한_선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String,Integer> hash = new HashMap<>();

        for(String start : participant){
            hash.put(start, hash.getOrDefault(start,0) + 1);
        }

        for(String result : completion){

            if(hash.containsKey(result))
                hash.put(result, hash.get(result) - 1);

        }

        for(String confirm : hash.keySet()){//hash.keySet() :
            // hash 안에 있는 key들을 모두 불러오는 method
            if(hash.get(confirm) != 0)
                answer += confirm;
        }
        return answer;
    }
}
