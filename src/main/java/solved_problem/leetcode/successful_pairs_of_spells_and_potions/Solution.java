package solved_problem.leetcode.successful_pairs_of_spells_and_potions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        List<Integer> successCounts = new ArrayList<>();

        Arrays.sort(potions);

        for (int spell : spells) {
            int successCount = countSuccess(potions, spell, success);
            successCounts.add(successCount);
        }

        return successCounts.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int countSuccess(int[] potions, int spell, long success) {
        int maxIndex = potions.length - 1;
        long minPotion = (long) Math.ceil((1.0 * success) / spell);
        long maxPotion = (long) potions[maxIndex] * spell; // type casting 에서 애먹음;

        if (minPotion > maxPotion) {
            return 0;
        }

        int lowBoundIndex = lowerBound(potions, (int) minPotion);
        return maxIndex - lowBoundIndex + 1;
    }

    private int lowerBound(int[] potions, int key) {
        int low = 0;
        int high = potions.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (potions[mid] < key) {
                low = mid + 1;
                continue;
            }

            high = mid;
        }

        return low;
    }

}
