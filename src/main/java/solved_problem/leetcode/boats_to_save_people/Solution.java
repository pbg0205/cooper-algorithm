package solved_problem.leetcode.boats_to_save_people;

import java.util.Arrays;

class Solution {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            answer++;

            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
        }

        return answer;
    }

}
