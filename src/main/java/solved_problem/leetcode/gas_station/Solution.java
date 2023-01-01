package solved_problem.leetcode.gas_station;

/**
 * Runtime: 0 ms, faster than 100.00% of Java
 * Memory Usage: 39.3 MB, less than 52.60% of Java
 */

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (sum(gas) < sum(cost)) {
            return -1;
        }

        int start = 0;
        int fuel = 0;

        for (int i = 0; i < gas.length; i++) {
            if (gas[i] + fuel < cost[i]) {
                start = i + 1;
                fuel = 0;
                continue;
            }
            fuel += gas[i] - cost[i];
        }

        return start;
    }

    private int sum(int[] gas) {
        int result = 0;
        for (int element : gas) {
            result += element;
        }
        return result;
    }
}
