package solved_problem.programmers.level01.크기가_작은_부분문자열;

class Solution {

    public int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        long pNumber = Long.parseLong(p);

        int endIndex = t.length() - pLength + 1;
        for (int index = 0; index < endIndex; index++) {
            long parsingNumber = Long.parseLong(t.substring(index, index + pLength));
            if (parsingNumber <= pNumber) {
                answer++;
            }
        }

        return answer;
    }

}
