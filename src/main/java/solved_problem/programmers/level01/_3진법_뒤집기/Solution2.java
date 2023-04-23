package solved_problem.programmers.level01._3진법_뒤집기;

public class Solution2 {
    public int solution(int n) {
        String ternaryBaseNum = Integer.toString(n, 3);
        String reversedNumber = new StringBuilder(ternaryBaseNum).reverse().toString();
        return Integer.parseInt(reversedNumber, 3);
    }

}
