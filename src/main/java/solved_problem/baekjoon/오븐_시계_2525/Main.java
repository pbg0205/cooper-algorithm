package solved_problem.baekjoon.오븐_시계_2525;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int elapsedMinute = sc.nextInt();

		hour += elapsedMinute / 60;
		minute += elapsedMinute % 60;

		if(minute >= 60){
			hour += 1;
			minute -= 60;
		}
		if(hour >= 24){
			hour -= 24;
		}

		System.out.println(hour + " " + minute);
	}

}
