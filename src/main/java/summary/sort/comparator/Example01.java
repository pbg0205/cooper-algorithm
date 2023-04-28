package summary.sort.comparator;

import java.util.Arrays;

public class Example01 {

    // 내림차순 예시
    public static void main(String[] args) {
        int[] arr = {5, 3, 7, 4, 7, 4, 0, 9};
        int[] reversed = Arrays.stream(arr)
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .mapToInt(Integer::intValue)
                .toArray();

        System.out.println(Arrays.toString(reversed));
    }

}
