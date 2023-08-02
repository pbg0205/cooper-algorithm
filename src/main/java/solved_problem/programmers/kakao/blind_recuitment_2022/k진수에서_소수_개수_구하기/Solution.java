package solved_problem.programmers.kakao.blind_recuitment_2022.k진수에서_소수_개수_구하기;

import java.util.Arrays;

class Solution {

    public int solution(int n, int k) {

        String radixNumber = Long.toString(n, k);
        return (int) Arrays.stream(radixNumber.split("[0]+"))
                .mapToLong(Long::parseLong)
                .filter(this::isPrime)
                .count();
    }

    private boolean isPrime(long num) {
        if (num <= 1) {
            return false;
        }

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
