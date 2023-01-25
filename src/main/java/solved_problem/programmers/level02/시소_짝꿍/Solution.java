package solved_problem.programmers.level02.시소_짝꿍;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Solution {

    public long solution(int[] weights) {

        Set<Integer> weightSet = intWeightSet(weights);
        Map<Integer, List<Integer>> weightMap = initWeightMap(weights);
        return countSeesawPair(weightSet, weightMap);
    }

    private long countSeesawPair(Set<Integer> weightSet, Map<Integer, List<Integer>> weightMap) {
        List<Integer> distances = List.of(2, 3, 4);
        long answer = 0;
        for (Integer weight : weightSet) {
            int weightSize = weightMap.get(weight).size();
            if (weightSize > 1) {
                answer += ((long) weightSize * (long) (weightSize - 1)) / 2;
            }

            for (Integer left : distances) {
                for (Integer right : distances) {
                    if (Objects.equals(left, right)) {
                        continue;
                    }

                    int weightCandidate = weight * left / right;
                    boolean weightPossible = ((weight * left % right) == 0);
                    if (weightPossible && weightMap.containsKey(weightCandidate)) {
                        answer += (long) weightMap.get(weightCandidate).size() * (long) weightSize;
                    }
                }
            }

            weightMap.remove(weight);
        }

        return answer;
    }

    private Set<Integer> intWeightSet(int[] weights) {
        Set<Integer> weightSet = new HashSet<>();
        for (Integer weight : weights) {
            weightSet.add(weight);
        }
        return weightSet;
    }

    private Map<Integer, List<Integer>> initWeightMap(int[] weights) {
        Map<Integer, List<Integer>> weightMap = new HashMap();
        
        for (int weight : weights) {
            weightMap.put(weight, new ArrayList<>());
        }
        
        for (int index = 0; index < weights.length; index++) {
            int weight = weights[index];
            if (!weightMap.containsKey(weight)) {
                weightMap.put(weight, new ArrayList<>());
            }

            List<Integer> weightIndexList = weightMap.get(weight);
            weightIndexList.add(index);
        }

        return weightMap;
    }

}
