package solved_problem.programmers.level02.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> movingQueue = new LinkedList<>();
        Queue<Truck> waitQueue = new LinkedList<>();

        for (int truckWeight : truck_weights) {
            waitQueue.offer(new Truck(truckWeight));
        }

        int answer = 0;
        int currentWeight = 0;

        while (!(movingQueue.isEmpty() && waitQueue.isEmpty())) {
            answer++;

            if (movingQueue.isEmpty()) {
                Truck truck = waitQueue.poll();
                currentWeight += truck.getWeight();
                movingQueue.offer(truck);
                continue;
            }

            for (Truck truck : movingQueue) {
                truck.move();
            }

            if (movingQueue.peek().getMoveCount() > bridge_length) {
                Truck truck = movingQueue.poll();
                currentWeight -= truck.getWeight();
            }

            if (!waitQueue.isEmpty() && currentWeight + waitQueue.peek().getWeight() <= weight) {
                Truck truck = waitQueue.poll();
                currentWeight += truck.getWeight();
                movingQueue.offer(truck);
            }
        }

        return answer;
    }
}

class Truck {
    private int weight = 0;
    private int moveCount = 1;

    public Truck(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        this.moveCount++;
    }
}
