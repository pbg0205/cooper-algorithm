package solved_problem.programmers.level02.쿼드_압축_후_개수_세기;

class Solution2 {

    public int[] solution(int[][] arr) {
        return new int[]{
                count(0, 0, arr.length, arr, 0),
                count(0, 0, arr.length, arr, 1)};
    }

    private int count(int offsetY, int offsetX, int size, int[][] arr, int countNum) {
        int h = size / 2;

        for (int y = offsetY; y < offsetY + size; y++) {
            for (int x = offsetX; x < offsetX + size; x++) {
                if (arr[y][x] != countNum) {
                    return count(offsetY, offsetX, h, arr, countNum)
                            + count(offsetY + h, offsetX, h, arr, countNum)
                            + count(offsetY, offsetX + h, h, arr, countNum)
                            + count(offsetY + h, offsetX + h, h, arr, countNum);
                }
            }
        }

        if (arr[offsetY][offsetX] == countNum) {
            return 1;
        }
        return 0;
    }

}
