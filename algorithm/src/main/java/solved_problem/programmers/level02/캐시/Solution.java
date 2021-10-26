package solved_problem.programmers.level02.캐시;

import java.util.LinkedList;
import java.util.Locale;

class Solution {

    private int cacheHit;
    private int cacheMiss;

    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        int answer = 0;

        LinkedList<String> cache = new LinkedList<>();

        for (String city : cities) {
            city = city.toUpperCase(Locale.ROOT);

            if (cache.remove(city)) {
                cache.addFirst(city);
                cacheHit = 1;
                answer += cacheHit;
                continue;
            }

            int currentSize = cache.size();

            if (currentSize == cacheSize) {
                cache.pollLast();
            }

            cache.addFirst(city);
            cacheMiss = 5;
            answer += cacheMiss;
        }
        return answer;
    }
}
