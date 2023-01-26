package solved_problem.programmers.level02.두_큐_합_같게_만들기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long leftSum = 0;
        long rightSum = 0;
        int limit = 600_000;

        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        for (int index = 0; index < queue1.length; index++) {
            leftQueue.add(queue1[index]);
            leftSum += queue1[index];
        }

        for (int index = 0; index < queue2.length; index++) {
            rightQueue.add(queue2[index]);
            rightSum += queue2[index];
        }

        if ((leftSum + rightSum) % 2 == 1) {
            return -1;
        }

        int moveCount = 0;
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty() && moveCount <= limit) {
            if (leftSum == rightSum) {
                break;
            }

            if (leftSum > rightSum) {
                int leftPollNumber = leftQueue.poll();
                rightQueue.offer(leftPollNumber);
                rightSum += leftPollNumber;
                leftSum -= leftPollNumber;
                answer++;
            }

            if (leftSum < rightSum) {
                int rightPollNumber = rightQueue.poll();
                leftQueue.offer(rightPollNumber);
                leftSum += rightPollNumber;
                rightSum -= rightPollNumber;
                answer++;
            }

            moveCount++;
        }

        if (leftSum != rightSum) {
            return -1;
        }

        return answer;
    }

}
