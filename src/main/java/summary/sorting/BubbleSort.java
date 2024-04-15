package summary.sorting;

import java.util.Arrays;

class BubbleSort {
	public static void main(String[] args) {
		int[] numbers = new int[]{3, 4, 6, 5, 1, 2, 10, 9, 8, 7};

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					swap(numbers, i, j);
				}
			}
			System.out.println(Arrays.toString(numbers));
		}

		System.out.println(Arrays.toString(numbers));
	}

	private static void swap(final int[] numbers, final int i, final int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
