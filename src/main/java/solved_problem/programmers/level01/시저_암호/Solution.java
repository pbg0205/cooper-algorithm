package solved_problem.programmers.level01.시저_암호;

class Solution {

    private static final int ALPHABET_SIZE = 26;

    public String solution(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            stringBuilder.append(caesarCipher(c, n));
        }

        return stringBuilder.toString();
    }

    private char caesarCipher(char c, int moveCount) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        int baseA = Character.isUpperCase(c) ? 'A' : 'a';
        int offset = (c - baseA + moveCount) % ALPHABET_SIZE;
        return (char) (offset + baseA);
    }

}
