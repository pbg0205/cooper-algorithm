package sample;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1}; // 최악, 최선, 평균 시간 복잡도

		insertionSort(numbers);
	}

	private static void insertionSort(final int[] numbers) {
		// 9, 8, 7, 6, 5, 4, 3, 2, 1
		// 8, 9
		// 7, 8, 9
		// 6, 7, 8, 9
		for (int i = 1; i < numbers.length; i++) {
			int j = i;
			while (j > 0) {
				if (numbers[j - 1] > numbers[j]) {
					swap(numbers, j - 1, j);
				}
				j--;
			}

			System.out.println(Arrays.toString(numbers));
		}
	}

	private static void swap(final int[] numbers, final int left, final int right) {
		int temp = numbers[left];
		numbers[left] = numbers[right];
		numbers[right] = temp;
	}

}
