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

    private char caesarCipher(char c, int n) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ALPHABET_SIZE;
        return (char) (position + offset);
    }

}
