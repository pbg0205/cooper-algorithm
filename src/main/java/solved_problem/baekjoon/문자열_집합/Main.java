package solved_problem.baekjoon.문자열_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(br.readLine(), 1);
		}

		for(int i = 0;  i < m; i++){
			String pattern = br.readLine();
			if(map.get(pattern) != null){
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
