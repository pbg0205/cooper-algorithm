package solved_problem.programmers.level03.단속카메라;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int solution(int[][] routes) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            carList.add(new Car(i, routes[i][0], routes[i][1]));
        }

        carList.sort(Comparator.comparingInt(Car::getEndPoint));
        int answer = 0;
        int cameraLocation = Integer.MIN_VALUE;
        for (Car car : carList) {
            if (cameraLocation >= car.getStartPoint()) {
                continue;
            }
            cameraLocation = car.getEndPoint();
            answer++;
        }

        return answer;
    }
}

class Car {
    private int index;
    private int startPoint;
    private int endPoint;

    public Car(int index, int startPoint, int endPoint) {
        this.index = index;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getIndex() {
        return index;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    @Override
    public String toString() {
        return "Car{" +
                "index=" + index +
                ", startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}
