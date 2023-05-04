package solved_problem.programmers.level01.푸드_파이트_대회;

class Solution {

    public String solution(int[] food) {
        StringBuilder foodOrder = new StringBuilder();

        for (int index = 1; index < food.length; index++) {
            int mod = food[index] / 2;
            for (int count = 1; count <= mod; count++) {
                foodOrder.append(index);
            }
        }

        StringBuilder reverseFoodOrder = new StringBuilder(foodOrder).reverse();
        String water = "0";

        return foodOrder.append(water)
                .append(reverseFoodOrder)
                .toString();
    }

}
