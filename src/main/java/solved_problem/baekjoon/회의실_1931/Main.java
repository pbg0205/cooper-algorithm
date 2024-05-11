package solved_problem.baekjoon.회의실_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{

	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi(br.readLine());

		arr = new int[n][2];
		for (int idx = 0; idx < n; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[idx][0] = stoi(st.nextToken());
			arr[idx][1] = stoi(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] start, int[] end) {
				//start[0], end[0] 배열은 arr[][] 의 첫번째 라인(시작시간)이다.
				//start[1], end[0] 배열은 arr[][] 의 두번째 라인(종료시간)이다.
				if(start[1]==end[1]){
					//만약 비교하는 값의 종료시간이 같을 경우 시작시간으로 정렬한다.
					return Integer.compare(start[0], end[0]);
				}
				//종료시간에 따라 정렬한다.
				return Integer.compare(start[1], end[1]);
			}

		});

		int count = 0;
		int end = -1;

		for (int idx = 0; idx < n; idx++) {
			if(arr[idx][0] >= end) {
				end = arr[idx][1];
				count++;
			}
		}

		System.out.println(count);

		br.close();
	}

	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
}
