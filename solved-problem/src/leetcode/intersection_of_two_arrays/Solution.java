package leetcode.intersection_of_two_arrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        for (int num : nums2) {
            nums2Set.add(num);
        }

        Set<Integer> intersection = new HashSet<>();

        for (Integer num1 : nums1Set) {
            if (nums2Set.contains(num1)) {
                intersection.add(num1);
            }
        }

        int idx = 0;
        int[] result = new int[intersection.size()];
        for (Integer element : intersection) {
            result[idx++] = element;
        }

        return result;
    }
}
