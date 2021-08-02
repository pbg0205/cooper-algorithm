package solved_problem.leetcode.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * - Runtime: 1 ms, faster than 92.92%
 * - Memory Usage: 39.3 MB, less than 43.18%
 */

public class Solution {
    int n;
    boolean[] visited;
    List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        visited = new boolean[n];
        result = new ArrayList<>();

        permute(new ArrayList<>(), nums);

        return result;
    }

    private void permute(ArrayList<Integer> list, int[] nums) {
        if (list.size() == n) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;

                permute(list, nums);

                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
