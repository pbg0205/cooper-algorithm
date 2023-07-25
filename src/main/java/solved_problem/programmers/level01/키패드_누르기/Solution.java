package solved_problem.programmers.level01.키패드_누르기;

class Solution {

    private static final String LEFT = "L";
    private static final String RIGHT = "R";

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] leftIndex = {3, 0};
        int[] rightIndex = {3, 2};

        //1,4,7 -> 왼손
        //3,6,9 -> 오른손
        //2,5,8,0 -> 가까운 위치 기준
        // 길이가 같을 때는 손잡이 기준

        for (int number : numbers) {
            // 1. 왼손 위치에 있을 경우
            if (locateLeft(number)) {
                answer.append(LEFT);
                if (number - 1 == -1) {
                    leftIndex[0] = 3;
                    leftIndex[1] = 1;
                } else {
                    leftIndex[0] = (number - 1) / 3;
                    leftIndex[1] = (number - 1) % 3;
                }

            }

            // 2. 오른손 위치에 있을 경우
            if (locateRight(number)) {
                answer.append(RIGHT);
                if (number - 1 == -1) {
                    rightIndex[0] = 3;
                    rightIndex[1] = 1;
                } else {
                    rightIndex[0] = (number - 1) / 3;
                    rightIndex[1] = (number - 1) % 3;
                }

            }

            // 3. 가운데 위치에 있을 경우, 거리가 짧은 손으로 클릭
            if (locateMiddle(number)) {
                int[] nowIndex = number == 0 ?
                        new int[]{3, 1} :
                        new int[]{(number - 1) / 3, (number - 1) % 3};

                int distanceToLeft = Math.abs(nowIndex[0] - leftIndex[0])
                        + Math.abs(nowIndex[1] - leftIndex[1]);
                int distanceToRight = Math.abs(nowIndex[0] - rightIndex[0])
                        + Math.abs(nowIndex[1] - rightIndex[1]);

                if (distanceToLeft > distanceToRight) {
                    answer.append(RIGHT);
                    if (number - 1 == -1) {
                        rightIndex[0] = 3;
                        rightIndex[1] = 1;
                    } else {
                        rightIndex[0] = (number - 1) / 3;
                        rightIndex[1] = (number - 1) % 3;
                    }

                    continue;
                }

                if (distanceToLeft < distanceToRight) {
                    answer.append(LEFT);
                    if (number - 1 == -1) {
                        leftIndex[0] = 3;
                        leftIndex[1] = 1;
                    } else {
                        leftIndex[0] = (number - 1) / 3;
                        leftIndex[1] = (number - 1) % 3;
                    }

                    continue;
                }

                // 4. 오른쪽, 왼쪽 서로 길이가 같을 경우, 주된 손잡이로 고른다.
                if (hand.equals("left")) {
                    answer.append(LEFT);
                    if (number - 1 == -1) {
                        leftIndex[0] = 3;
                        leftIndex[1] = 1;
                        continue;
                    }

                    leftIndex[0] = (number - 1) / 3;
                    leftIndex[1] = (number - 1) % 3;
                } else {
                    answer.append(RIGHT);
                    if (number - 1 == -1) {
                        rightIndex[0] = 3;
                        rightIndex[1] = 1;
                        continue;
                    }

                    rightIndex[0] = (number - 1) / 3;
                    rightIndex[1] = (number - 1) % 3;
                }
            }
        }

        return answer.toString();
    }

    private static boolean locateMiddle(int number) {
        return number == 2 || number == 5
                || number == 8 || number == 0;
    }

    private static boolean locateRight(int number) {
        return number == 3 || number == 6 || number == 9;
    }

    private static boolean locateLeft(int number) {
        return number == 1 || number == 4 || number == 7;
    }

}
