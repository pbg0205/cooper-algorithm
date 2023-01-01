package solved_problem.programmers.level02._124나라의_숫자;

class Solution {
    private static int[] movements;

    public int solution(String name) {
        int answer = 0;

        movements = new int[name.length()];

        for (char alphabet : name.toCharArray()) {
            int aToAlpha = alphabet - 'A';
            int alphaToZ = 'Z' - alphabet + 1;

            movements[answer] = Math.min(aToAlpha, alphaToZ);
        }

        int nowIndex = 0;

        while (true) {
            int leftIndex = nowIndex;
            int rightIndex = nowIndex;

            if (movements[nowIndex] != 0) {
                answer += movements[nowIndex];
                movements[nowIndex] = 0;
            }

            if (areAllZero()) {
                break;
            }

            int move = 0;

            while (true) {
                leftIndex--;
                rightIndex++;
                move++;

                if(leftIndex < 0) {
                    leftIndex = movements.length - 1;
                }

                if(rightIndex >= movements.length) {
                    rightIndex = 0;
                }

                if(movements[rightIndex] != 0) {
                    answer += move;
                    nowIndex = rightIndex;
                    break;
                }

                if(movements[leftIndex] != 0) {
                    answer += move;
                    nowIndex = leftIndex;
                    break;
                }
            }
        }

        return answer;
    }

    private boolean areAllZero() {
        for (int movement : movements) {
            if(movement != 0) {
                return false;
            }
        }
        return true;
    }
}