package solved_problem.programmers.level02.멀쩡한_사각형;

class Solution {
    public long solution(int w, int h) {
        long widthAsLong = w;
        long heightAsLong = h;

        return (widthAsLong * heightAsLong)
                - (widthAsLong + heightAsLong - gcd(widthAsLong, heightAsLong));
    }

    public long gcd(long width, long height) {
        long big = width >= height ? width : height;
        long small = width < height ? width : height;

        while(small != 0) {
            long divided = big % small;
            big = small;
            small = divided;
        }

        return big;
    }
}
