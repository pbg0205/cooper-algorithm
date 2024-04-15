package summary.sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] numbers = new int[]{3, 4, 5, 6, 1, 2, 10, 9, 8, 7};
		quickSort(numbers, 0, numbers.length - 1);

		System.out.println(Arrays.toString(numbers));
	}

	private static void quickSort(final int[] numbers, final int low, final int high) {
		if (low < high) {
			int pivot = partition(numbers, low, high);
			quickSort(numbers, low, pivot - 1);
			quickSort(numbers, pivot + 1, high);
		}
	}

	private static int partition(final int[] numbers, final int low, final int high) {
		int pivot = numbers[high];
		int left = low;

		for (int right = low; right < high; right++) {
			if (numbers[right] < pivot) {
				swap(numbers, left, right);
				left++;
			}
		}

		swap(numbers, left, high);

		System.out.println(Arrays.toString(numbers));

		return left;
	}

	private static void swap(final int[] numbers, final int left, final int right) {
		int temp = numbers[left];
		numbers[left] = numbers[right];
		numbers[right] = temp;
	}

}
