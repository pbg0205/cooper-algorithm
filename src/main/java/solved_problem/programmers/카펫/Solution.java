package solved_problem.programmers.카펫;

class Solution {

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;

        for (int i = 1; i <= yellow ; i++) {
            if(yellow % i == 0){
                y = yellow / i;
                x = yellow / y;
            }else{
                continue;
            }

            if(brown == (x + 2) * (y + 2) - yellow){
                answer[0] = x >= y ? x + 2 : y + 2;
                answer[1] = x >= y ? y + 2 : x + 2;
                return answer ;
            }
        }

        return answer;
    }

}
