package solved_problem.programmers.level01.문자열_내림차순_배치하기;

class Solution {

    public String solution(String s) {
        return s.chars() // ascii-code ('A' : 65, 'a' : 97)
                .boxed()
                .sorted((v1, v2) -> v2 - v1)
                .collect(
                        StringBuilder::new,
                        StringBuilder::appendCodePoint, //ascii-code 의 character 를 추가한다.
                        StringBuilder::append)
                .toString();
    }

}
