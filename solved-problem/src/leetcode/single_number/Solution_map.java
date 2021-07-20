package leetcode.single_number;

import java.util.*;

/**
 * - Runtime: 7 ms, faster than 44.05% of Java
 * - Memory Usage: 39.7 MB, less than 31.07% of Java
 */

class Solution_map {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }

        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            }
        }
        return 0;
    }
}
