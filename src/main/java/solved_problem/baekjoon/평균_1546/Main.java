package solved_problem.baekjoon.평균_1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double subNum = Double.parseDouble(br.readLine());
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line, " ");
		double maxValue = 0; double sum = 0; double subPoint;
		while(st.hasMoreTokens()) {
			subPoint = Double.parseDouble(st.nextToken());
			maxValue = (maxValue < subPoint) ? subPoint : maxValue;
			sum += subPoint;
		}

		sum = (sum/maxValue) * 100.0;
		double avr = sum / subNum;
		System.out.println(avr);
	}
}
