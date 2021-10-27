package solved_problem.baekjoon.음계_2920;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            list.add(sc.nextInt());
        }

        boolean isAscending = true;
        for (int i = 0; i < list.size() - 1; i++) {
            if (!(list.get(i) < list.get(i + 1))) {
                isAscending = false;
            }
        }


        boolean isDescending = true;
        for (int i = list.size() - 1; i > 0; i--) {
            if (!(list.get(i - 1) > list.get(i))) {
                isDescending = false;
            }
        }

        if (isAscending) {
            System.out.println("ascending");
            return;
        }

        if (isDescending) {
            System.out.println("descending");
            return;
        }

        System.out.println("mixed");

        sc.close();
    }
}
