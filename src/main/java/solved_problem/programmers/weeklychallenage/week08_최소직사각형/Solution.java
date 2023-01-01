package solved_problem.programmers.weeklychallenage.week08_최소직사각형;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;

        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];

            if (width < height) {
                int temp = width;
                width = height;
                height = temp;
            }

            if (width > maxWidth) {
                maxWidth = width;
            }

            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        return maxWidth * maxHeight;
    }
}
