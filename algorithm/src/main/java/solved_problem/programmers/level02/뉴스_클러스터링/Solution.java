package solved_problem.programmers.level02.뉴스_클러스터링;

import java.util.*;

class Solution {
    private static final int MULTIPLY_NUMBER = 65536;

    private static double unionCount = 0;
    private static double intersectionCount = 0;

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        Map<String, Integer> str1Map = initSet(str1);
        Map<String, Integer> str2Map = initSet(str2);

        Map<String, Integer> interMap = new HashMap<>();

        for (String key : str1Map.keySet()) {
            if (str2Map.containsKey(key) && !interMap.containsKey(key)) {
                interMap.put(key, Math.min(str1Map.get(key), str2Map.get(key)));
            }
        }

        for (Map.Entry<String, Integer> entry : interMap.entrySet()) {
            intersectionCount += entry.getValue();
        }

        unionCount -= intersectionCount;
        System.out.println(unionCount + " " + intersectionCount);

        if (unionCount == 0) {
            return MULTIPLY_NUMBER;
        }

        return (int) Math.floor(MULTIPLY_NUMBER * (intersectionCount / unionCount));
    }

    private Map<String, Integer> initSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        char[] arr = str.toCharArray();

        for (int i = 0; i < str.length() - 1; i++) {
            String temp;

            if (Character.isLetter(arr[i]) && Character.isLetter(arr[i + 1])) {
                temp = "" + arr[i] + arr[i + 1];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                unionCount++;
            }
        }

        return map;
    }
}