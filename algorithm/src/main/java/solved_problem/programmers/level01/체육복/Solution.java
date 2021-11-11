package solved_problem.programmers.level01.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        //1. 전체 학생들의 배열 생성(기준 1로 설정)
        int[] student = new int[n+1];
        Arrays.fill(student, 1);

        for(int reserveStuNum : reserve)	student[reserveStuNum] += 1;//여벌의 체육복을 가지고 있는 학생처리
        for(int lostStuNum  : lost)	student[lostStuNum] -= 1;//체육복을 잃어버린 학생 처리

        //체육복 빌려줄지 말지 하는 알고리즘
        for(int lostStuNum  : lost) {
            int prev_lostStuNum = lostStuNum -1;
            int back_lostStunum = lostStuNum + 1;

            for (int i = 0; i < reserve.length; i++) {
                if(prev_lostStuNum == reserve[i] || back_lostStunum == reserve[i]) {
                    if(student[reserve[i]] > 1 && student[lostStuNum] == 0) {
                        student[lostStuNum]++;
                        student[reserve[i]]--;
                    }
                }
            }
        }

        //수업에 참여할 수 있는 수 count
        for (int i = 1; i < student.length; i++) {
            if(student[i] >= 1) answer++;
        }
        return answer;
    }
}