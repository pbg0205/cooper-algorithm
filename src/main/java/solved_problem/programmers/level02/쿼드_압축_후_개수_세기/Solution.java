package solved_problem.programmers.level02.쿼드_압축_후_개수_세기;

class Solution {

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);
        return new int[]{count.zeroCount, count.oneCount};
    }

    private Count count(int offsetY, int offsetX, int size, int[][] arr) {
        int h = size / 2;

        for (int y = offsetY; y < offsetY + size; y++) {
            for (int x = offsetX; x < offsetX + size; x++) {
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetY, offsetX, h, arr)
                            .add(count(offsetY + h, offsetX, h, arr))
                            .add(count(offsetY, offsetX + h, h, arr))
                            .add(count(offsetY + h, offsetX + h, h, arr));
                }
            }
        }

        if (arr[offsetY][offsetX] == 1) {
            return new Count(0, 1);
        }

        return new Count(1, 0);
    }

    private static class Count {
        private final int zeroCount;
        private final int oneCount;

        public Count(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }

        public Count add(Count other) {
            return new Count(this.zeroCount + other.zeroCount, this.oneCount + other.oneCount);
        }
    }
}
