package solved_problem.programmers.weeklychallenage.week01;

class Solution {
    public long solution(int price, int money, int count) {
        long priceSum = getPriceSumByCount(price, count);
        long insufficientMoney = priceSum - money >= 0 ? priceSum - money : 0;
        return  insufficientMoney;
    }

    private long getPriceSumByCount(int price, int count) {
        long sumOfCount = (count * (count + 1)) / 2;
        return price * sumOfCount;
    }
}
