package solved_problem.programmers.kakao_internship_2021.거리두기_확인하기;

class Solution {

    private static final char PERSON = 'P';
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int count = 0; count < answer.length; count++) {
            String[] place = places[count];
            char[][] room = new char[place.length][];

            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }

            if (isDistanced(room)) {
                answer[count]++;
            }
        }

        return answer;
    }

    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[0].length; x++) {
                if (room[y][x] != 'P') {
                    continue;
                }

                if (!isDistanced(room, y, x)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isDistanced(char[][] room, int y, int x) {
        for (int idx = 0; idx < direction.length; idx++) {
            int ny = y + direction[idx][0];
            int nx = x + direction[idx][1];

            if (isOutBound(room, ny, nx)) {
                continue;
            }

            char position = room[ny][nx];
            if (position == 'P') {
                return false;
            }

            if (position == 'O') {
                if (isNextToVolunteer(room, ny, nx, 3 - idx)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int y, int x, int exceptDirection) {
        for (int idx = 0; idx < direction.length; idx++) {
            if (idx == exceptDirection) {
                continue;
            }

            int ny = y + direction[idx][0];
            int nx = x + direction[idx][1];

            if (isOutBound(room, ny, nx)) {
                continue;
            }

            char position = room[ny][nx];
            if (position == 'P') {
                return true;
            }
        }
        return false;
    }

    private boolean isOutBound(char[][] room, int y, int x) {
        return ((y < 0) || (y >= room.length)) || (x < 0) || (x >= room[0].length);
    }

}
