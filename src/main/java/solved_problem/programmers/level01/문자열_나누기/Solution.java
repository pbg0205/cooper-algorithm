package solved_problem.programmers.level01.문자열_나누기;

class Solution {

    public int solution(String s) {
        int answer = 0;

        int firstAlphabetCount = 0;
        int otherAlphabetCount = 0;

        char firstAlphabet = s.charAt(0);
        for (int index = 0; index < s.length(); index++) {
            if (firstAlphabetCount == 0) {
                firstAlphabet = s.charAt(index);
                firstAlphabetCount++;
                continue;
            }

            if (s.charAt(index) == firstAlphabet) {
                firstAlphabetCount++;
                continue;
            }

            otherAlphabetCount++;
            if (firstAlphabetCount == otherAlphabetCount) {
                System.out.println(s.charAt(index));
                answer++;
                firstAlphabetCount = 0;
                otherAlphabetCount = 0;
            }
        }

        if (!(firstAlphabetCount == 0 && otherAlphabetCount == 0)) {
            answer++;
        }

        return answer;
    }

}
