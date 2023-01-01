package solved_problem.programmers.level02.전화번호목록;

import java.util.Arrays;

public class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        int index = 0;
        while (index < phone_book.length) {
            String nowPhoneNumber = phone_book[index];
            String nextPhoneNumber = phone_book[index + 1];
            if (nextPhoneNumber.startsWith(nowPhoneNumber)) {
                return false;
            }
            index++;
        }
        return true;
    }
}
