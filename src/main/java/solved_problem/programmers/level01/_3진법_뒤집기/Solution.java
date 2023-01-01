package solved_problem.programmers.level01._3진법_뒤집기;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = "";

        while( n > 0) {
            temp = temp + (n % 3);
            n /= 3;
        }
        System.out.println(temp);
        for (int i = 0; i < temp.length(); i++) {
            answer += Math.pow(3, temp.length() - (i+1)) * (temp.charAt(i) - '0');
        }

        return answer;
    }

}