package solved_problem.baekjoon.모든수열_10974;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

	static int[] data;
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		for (int i = 1; i <= N; i++)	data[i] = i;

		do {
			for (int idx = 1; idx <= N; idx++)
				bw.write(String.valueOf(data[idx]) + " ");

			bw.write("\n");
		}while(isNextPermutation(data));

		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean isNextPermutation(int[] data){
		int prev = data.length - 1;
		while(prev > 1 && data[prev - 1] >= data[prev]) {
			prev--;
		}

		if(prev <= 1) {
			return false;
		}

		int after = data.length - 1;
		while(data[prev-1] >= data[after]) {
			after--;
		}

		swap(data, prev - 1, after);

		after = data.length - 1;

		while(prev < after) {
			swap(data, prev, after);
			prev++;
			after--;
		}

		return true;
	}

	private static void swap(int[] data, int prev, int next) {
		int temp = data[prev];
		data[prev] = data[next];
		data[next] = temp;
	}
}
