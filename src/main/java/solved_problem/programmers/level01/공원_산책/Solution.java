package solved_problem.programmers.level01.공원_산책;

class Solution {

    public int[] solution(String[] park, String[] routes) {
        char[][] parkMap = new char[park.length][];
        int nowY = Integer.MIN_VALUE;
        int nowX = Integer.MIN_VALUE;
        for (int idx = 0; idx < park.length; idx++) {
            parkMap[idx] = park[idx].toCharArray();

            if (park[idx].contains("S")) {
                nowY = idx;
                nowX = park[idx].indexOf("S");
            }
        }

        for (String route : routes) {
            String[] split = route.split(" ");
            String direction = split[0];
            int moveCount = Integer.parseInt(split[1]);

            int nextY = nowY;
            int nextX = nowX;

            for (int count = 0; count < moveCount; count++) {
                if (direction.equals("N")) {
                    nextY--;
                }

                if (direction.equals("E")) {
                    nextX++;
                }

                if (direction.equals("S")) {
                    nextY++;
                }

                if (direction.equals("W")) {
                    nextX--;
                }

                if (isOutBound(nextY, nextX, parkMap) || parkMap[nextY][nextX] == 'X') {
                    break;
                }

                if (count == moveCount - 1) {
                    nowY = nextY;
                    nowX = nextX;
                }
            }

        }

        return new int[]{nowY, nowX};
    }

    private boolean isOutBound(int y, int x, char[][] parkMap) {
        return !((0 <= y && y < parkMap.length) && (0 <= x && x < parkMap[0].length));
    }

}
