package summary.sorting;

import java.util.Arrays;

class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = new int[]{3, 4, 6, 5, 1, 2, 10, 9, 8, 7};

		int i = 1;
		while (i < numbers.length) {
			int j = i;
			while (j > 0 && numbers[j - 1] > numbers[j]) {
				swap(numbers, j - 1, j);
				j--;
			}
			System.out.println(Arrays.toString(numbers));
			i++;
		}

		System.out.println(Arrays.toString(numbers));
	}

	private static void swap(final int[] numbers, final int i, final int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
