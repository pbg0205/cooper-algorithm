package solved_problem.baekjoon.분산처리_1009;

import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		List<int[]> modList = new ArrayList<>();

		modList = initModList(modList);

		while (n-- > 0) {
			String[] line = scanner.nextLine().split(" ");
			int dataNum = Integer.parseInt(line[0]);
			int exponent = Integer.parseInt(line[1]);

			if (dataNum == 10) {
				dataNum = 0;
			}

			if(dataNum > 10) {
				dataNum %= 10;
			}

			int[] modArray = modList.get(dataNum);

			int size = modArray.length;
			int mod = exponent % size;


			System.out.println(modArray[mod]);
		}

		scanner.close();
	}

	private static List<int[]> initModList(List<int[]> modList) {
		modList.add(new int[]{10});
		modList.add(new int[]{1});
		modList.add(new int[]{6, 2, 4, 8});
		modList.add(new int[]{1, 3, 9, 7});
		modList.add(new int[]{6, 4});
		modList.add(new int[]{5});
		modList.add(new int[]{6});
		modList.add(new int[]{1, 7, 9, 3});
		modList.add(new int[]{6, 8, 4, 2});
		modList.add(new int[]{1, 9});

		return modList;
	}
}
