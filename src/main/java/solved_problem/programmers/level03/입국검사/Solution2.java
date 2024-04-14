package solved_problem.programmers.level03.입국검사;

import java.util.Arrays;

class Solution2 {
	public long solution(int n, int[] times) {
		long answer = 0;

		long timeMin = 1; // 입국 시간 최소 값
		long timeMax = (long) Arrays.stream(times).max().getAsInt() * n; // 입국 시간 최대 값
		long timeMid = timeMax; // 입국 시간 중간 값

		while(timeMin <= timeMax) {
			System.out.println("timeMin = " + timeMin);
			System.out.println("timeMax = " + timeMax);
			System.out.println("timeMid = " + timeMid);

			long immigrationCount = 0; // 특정 시간의 입국 가능 사람 수
			for (int timePerOfficer : times) {
				immigrationCount += timeMid / timePerOfficer;
			}

			if (immigrationCount >= n) {
				timeMax = timeMid - 1;
				answer = timeMid; // n 명이 가능한 최소 값을 구하기 위한 로직
			} else {
				timeMin = timeMid + 1;
			}

			timeMid = timeMin + (timeMax - timeMin) / 2;
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		long result = solution.solution(6, new int[] {7, 10});
		System.out.println("result = " + result);
	}
}
