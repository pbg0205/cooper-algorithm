package solved_problem.programmers.level01.키패드_누르기;

class Solution {
    private static final String LEFT = "L";
    private static final String RIGHT = "R";

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] leftIndex = {3,0};
        int[] rightIndex = {3,2};

        //1,4,7 -> 왼손
        //3,6,9 -> 오른손
        //2,5,8,0 -> 가까운 위치 기준
        // 길이가 같을 때는 손잡이 기준

        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                addLeftResult(sb, leftIndex, number - 1);
            }

            if(number == 3 || number == 6 || number == 9) {
                addRightResult(sb, rightIndex, number - 1);
            }

            if(number == 2 || number == 5
                    || number == 8 || number == 0) {
                int[] nowIndex = new int[2];
                if(number == 0) {
                    nowIndex[0] = 3;
                    nowIndex[1] = 1;
                } else {
                    nowIndex[0] = (number - 1) / 3;
                    nowIndex[1] = (number - 1) % 3;

                }

                int lengthToLeft =
                        (int)Math.abs(nowIndex[0] - leftIndex[0])
                                + (int)Math.abs(nowIndex[1] - leftIndex[1]);
                int lengthToRight =
                        (int)Math.abs(nowIndex[0] - rightIndex[0])
                                + (int)Math.abs(nowIndex[1] - rightIndex[1]);

                if(lengthToLeft > lengthToRight) {
                    addRightResult(sb, rightIndex, number - 1);
                }else if (lengthToLeft < lengthToRight) {
                    addLeftResult(sb, leftIndex, number - 1);
                } else {
                    if(hand.equals("left")) {
                        addLeftResult(sb, leftIndex, number - 1);
                    } else {
                        addRightResult(sb, rightIndex, number - 1);
                    }
                }
            }
        }

        return sb.toString();
    }

    private void addRightResult(StringBuilder sb, int[] rightIndex, int number) {
        sb.append(RIGHT);
        if(number == -1) {
            rightIndex[0] = 3;
            rightIndex[1] = 1;
            return;
        }

        rightIndex[0] = number / 3;
        rightIndex[1] = number % 3;
    }

    private void addLeftResult(StringBuilder sb, int[] leftIndex, int number) {
        sb.append(LEFT);
        if(number == -1) {
            leftIndex[0] = 3;
            leftIndex[1] = 1;
            return;
        }

        leftIndex[0] = number / 3;
        leftIndex[1] = number % 3;
    }
}
