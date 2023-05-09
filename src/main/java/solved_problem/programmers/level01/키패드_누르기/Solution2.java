package solved_problem.programmers.level01.키패드_누르기;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution2 {

    public String solution(int[] numbers, String hand) {
        Hand right = new Hand("R", 2, hand.equals("right"));
        Hand left = new Hand("L", 0, hand.equals("left"));

        return Arrays.stream(numbers)
                .mapToObj(number -> press(number, right, left).hand)
                .collect(Collectors.joining());
    }

    private Hand press(int number, Hand right, Hand left) {
        int x = getX(number);
        int y = getY(number);

        float rDistance = right.distance(x, y);
        float lDistance = left.distance(x, y);

        Hand hand = null;
        if (rDistance > lDistance) {
            hand = left;
        } else if (rDistance < lDistance) {
            hand = right;
        }

        hand.move(x, y);
        return hand;
    }

    private int getX(int number) {
        if (number == 0) {
            return 1;
        }

        return (number - 1) % 3;
    }

    private int getY(int number) {
        if (number == 0) {
            return 3;
        }
        return (number - 1) / 3;
    }

    private static class Hand {
        private String hand;
        private final int baseX;
        private float preference;
        private int x;
        private int y;

        public Hand(String hand, int x, boolean isPreferred) {
            this.hand = hand;
            this.baseX = x;
            this.preference = isPreferred ? 0.5f : 0;
            this.x = x;
            this.y = 3;
        }

        public float distance(int x, int y) {
            if (baseX == x) {
                return 0;
            }

            return Math.abs(this.x - x) + Math.abs(this.y - y) - preference;
        }

        public void move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
