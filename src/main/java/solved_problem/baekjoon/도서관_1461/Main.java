package solved_problem.baekjoon.도서관_1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int sum = 0;
        StringTokenizer st = new StringTokenizer(BR.readLine());
        int totalBookCount = Integer.parseInt(st.nextToken());
        int bookCount = Integer.parseInt(st.nextToken());

        List<Integer> bookLocations = new ArrayList<>();
        st = new StringTokenizer(BR.readLine());
        while (st.hasMoreTokens()) {
            bookLocations.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> minusBookLocations = new ArrayList<>();
        List<Integer> plusBookLocations = new ArrayList<>();

        for (int bookLocation : bookLocations) {
            if (bookLocation < 0) {
                minusBookLocations.add(bookLocation);
            } else {
                plusBookLocations.add(bookLocation);
            }
        }

        minusBookLocations.sort(Comparator.naturalOrder());
        plusBookLocations.sort(Comparator.reverseOrder());

        int minValue = (minusBookLocations.size() == 0) ? 0 : minusBookLocations.get(0);
        int maxValue = (plusBookLocations.size() == 0) ? 0 : plusBookLocations.get(0);

        int plusIndex = 0;
        while (plusIndex < plusBookLocations.size()) {
            sum += plusBookLocations.get(plusIndex) * 2;
            plusIndex += bookCount;
        }

        int minusIndex = 0;
        while (minusIndex < minusBookLocations.size()) {
                sum -= minusBookLocations.get(minusIndex) * 2;
                minusIndex += bookCount;
        }

        sum -= Math.max(maxValue, -minValue);
        System.out.println(sum);
    }

}
