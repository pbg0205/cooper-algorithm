package solved_problem.programmers.level01.k번째수;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();

        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1] - 1;
            int[] tempArr = new int[end - start + 1];
            int findIndex = command[2] - 1;

            int index = 0;
            for (int i = start; i <= end; i++) {
                tempArr[index++] = arr[i];
            }

            quickSort(tempArr, 0, tempArr.length - 1);
            answerList.add(tempArr[findIndex]);
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private void quickSort(int[] arr, int start, int end) {
        int left = start;
        int right = end;
        int mid = (start + end) / 2;

        int pivot= arr[mid];
        do {
            while(arr[left] < pivot) {
                left++;
            }
            while(arr[right] > pivot) {
                right--;
            }

            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }while(left <= right);

        if(start < right) {
            quickSort(arr, start, right);
        }

        if(end > left) {
            quickSort(arr, left, end);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}