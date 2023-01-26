package solved_problem.programmers.level02.택배_배달과_수거하기;

import java.util.Stack;

class Solution {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> deliveryIndexStack = new Stack<>();
        Stack<Integer> pickupIndexStack = new Stack<>();

        for (int index = 0; index < deliveries.length; index++) {
            if (deliveries[index] != 0) {
                deliveryIndexStack.add(index);
            }
        }

        for (int index = 0; index < pickups.length; index++) {
            if (pickups[index] != 0) {
                pickupIndexStack.add(index);
            }
        }

        // (1) 가면서 배달 + 오면서 수거
        while (!deliveryIndexStack.isEmpty() && !pickupIndexStack.isEmpty()) {
            answer += (Math.max((deliveryIndexStack.peek() + 1) * 2, (pickupIndexStack.peek() + 1) * 2));

            int truckVolume = 0;
            while (!deliveryIndexStack.isEmpty() && truckVolume <= cap) {
                if (deliveries[deliveryIndexStack.peek()] + truckVolume <= cap) {
                    truckVolume += deliveries[deliveryIndexStack.peek()];
                } else {
                    deliveries[deliveryIndexStack.peek()] -= (cap - truckVolume);
                    break;
                }
                deliveryIndexStack.pop();
            }

            truckVolume = 0;
            while (!pickupIndexStack.isEmpty() && truckVolume <= cap) {
                if (pickups[pickupIndexStack.peek()] + truckVolume <= cap) {
                    truckVolume += pickups[pickupIndexStack.peek()];
                } else {
                    pickups[pickupIndexStack.peek()] -= (cap - truckVolume);
                    break;
                }
                pickupIndexStack.pop();
            }
        }

        // (2) 배달만 하는 경우
        while (!deliveryIndexStack.isEmpty()) {
            answer += (deliveryIndexStack.peek() + 1) * 2;

            int truckVolume = 0;
            while (!deliveryIndexStack.isEmpty() && truckVolume <= cap) {
                if (deliveries[deliveryIndexStack.peek()] + truckVolume <= cap) {
                    truckVolume += deliveries[deliveryIndexStack.peek()];
                } else {
                    deliveries[deliveryIndexStack.peek()] -= (cap - truckVolume);
                    break;
                }
                deliveryIndexStack.pop();
            }
        }

        // (3) 수거만 하는 경우
        while (!pickupIndexStack.isEmpty()) {
            answer += (pickupIndexStack.peek() + 1) * 2;

            int truckVolume = 0;
            while (!pickupIndexStack.isEmpty() && truckVolume <= cap) {
                if (pickups[pickupIndexStack.peek()] + truckVolume <= cap) {
                    truckVolume += pickups[pickupIndexStack.peek()];
                } else {
                    pickups[pickupIndexStack.peek()] -= (cap - truckVolume);
                    break;
                }
                pickupIndexStack.pop();
            }
        }

        return answer;
    }

}
