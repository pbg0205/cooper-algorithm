package solved_problem.programmers.level02.이진_변환_반복하기;

class Solution {

    public int[] solution(String s) {
        int zeroSum = 0;
        int loopSum = 0;
        String nowBinary = s;

        while (!nowBinary.equals("1")) {
            int zeroCount = countZero(nowBinary);
            zeroSum += zeroCount;
            loopSum++;
            nowBinary = Integer.toString(nowBinary.length() - zeroCount, 2);
        }

        return new int[]{loopSum, zeroSum};
    }

    private int countZero(String s) {
        int zeroCount = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == '0') {
                zeroCount++;
            }
        }

        return zeroCount;
    }

}
