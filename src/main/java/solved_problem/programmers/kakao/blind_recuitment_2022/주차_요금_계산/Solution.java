package solved_problem.programmers.kakao.blind_recuitment_2022.주차_요금_계산;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    private static final int MINUTES_PER_HOURS = 60;

    public int[] solution(int[] fees, String[] records) {
        Map<String, String> carEntranceTimeMap = new HashMap<>();
        Map<String, Integer> carElapsedTimeMap = new HashMap<>();

        for (String record : records) {
            String[] temp = record.split(" ");
            String recordTime = temp[0];
            String carNumber = temp[1];
            String access = temp[2];

            if (!carEntranceTimeMap.containsKey(carNumber) && access.equals("IN")) {
                carEntranceTimeMap.put(carNumber, recordTime);
            }

            if (carEntranceTimeMap.containsKey(carNumber) && access.equals("OUT")) {
                String carEntranceTime = carEntranceTimeMap.get(carNumber);
                int accumulatedMinutes = carElapsedTimeMap.getOrDefault(carNumber, 0)
                        + getElapsedMinutes(carEntranceTime, recordTime);

                carElapsedTimeMap.put(carNumber, accumulatedMinutes);
                carEntranceTimeMap.remove(carNumber);
            }
        }

        for (Map.Entry<String, String> entranceTimeMap : carEntranceTimeMap.entrySet()) {
            String carNumber = entranceTimeMap.getKey();
            String entranceTime = entranceTimeMap.getValue();
            carElapsedTimeMap.put(carNumber, carElapsedTimeMap.getOrDefault(carNumber, 0) + getElapsedMinutes(entranceTime, "23:59"));
        }

        return carElapsedTimeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(String::compareTo))
                .mapToInt(carElapsedTime -> calculateParkingFee(carElapsedTime.getValue(), fees))
                .toArray();
    }

    private int calculateParkingFee(int elapsedTime, int[] fees) {
        int freeElapsedTime = fees[0];
        int basicFee = fees[1];
        int minutesUnit = fees[2];
        int feeUnit = fees[3];

        if (freeElapsedTime >= elapsedTime) {
            return basicFee;
        }

        return basicFee + (int) Math.ceil((double) (elapsedTime - freeElapsedTime) / (double) minutesUnit) * feeUnit;
    }

    private int getElapsedMinutes(String carEntranceTime, String departureTime) {
        int[] entranceTimes = Arrays.stream(carEntranceTime.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] departureTimes = Arrays.stream(departureTime.split(":")).mapToInt(Integer::parseInt).toArray();

        int entranceHour = entranceTimes[0];
        int entranceMinute = entranceTimes[1];

        int departureHour = departureTimes[0];
        int departureMinute = departureTimes[1];

        return (departureHour - entranceHour) * MINUTES_PER_HOURS + (departureMinute - entranceMinute);
    }

}

/**
 * 테스트 1 〉  통과 (6.03ms, 76.7MB)
 * 테스트 2 〉  통과 (7.06ms, 78.4MB)
 * 테스트 3 〉  통과 (7.36ms, 79.9MB)
 * 테스트 4 〉  통과 (8.89ms, 85MB)
 * 테스트 5 〉  통과 (8.94ms, 78.9MB)
 * 테스트 6 〉  통과 (11.41ms, 76.4MB)
 * 테스트 7 〉  통과 (20.76ms, 79.4MB)
 * 테스트 8 〉  통과 (16.98ms, 82MB)
 * 테스트 9 〉  통과 (13.41ms, 76.5MB)
 * 테스트 10 〉 통과 (37.11ms, 73.1MB)
 * 테스트 11 〉 통과 (22.18ms, 84MB)
 * 테스트 12 〉 통과 (22.25ms, 75.1MB)
 * 테스트 13 〉 통과 (5.96ms, 78.6MB)
 * 테스트 14 〉 통과 (6.95ms, 76.8MB)
 * 테스트 15 〉 통과 (6.34ms, 91.5MB)
 * 테스트 16 〉 통과 (5.44ms, 80.9MB)
 */
