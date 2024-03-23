package solved_problem.baekjoon.화학식량_2257;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String chem = br.readLine();
		int stack[] = new int[100];
		int tmp = 0;
		int cnt = 0;
		for (int i = 0; i < chem.length(); i++) {
			char c = chem.charAt(i);

			if(c=='H') {
				tmp=1;
				stack[cnt] +=1;
			}else if(c=='C') {
				tmp=12;
				stack[cnt] +=12;
			}else if(c=='O') {
				tmp=16;
				stack[cnt] +=16;
			}else if(c=='(') {
				stack[++cnt]=0;
			}else if(c==')') {
				tmp = stack[cnt--];
				stack[cnt]+=tmp;
			}else if(c>'1' && c<='9') {
				stack[cnt]+=tmp*(c-'1');
			}
		}
		System.out.println(stack[0]);
	}
}
