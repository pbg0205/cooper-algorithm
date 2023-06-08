package solved_problem.baekjoon.ROT_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] inputChars = reader.readLine().toCharArray();
        for (int i = 0; i < inputChars.length; i++) {
            inputChars[i] = encryptROT13(inputChars, i);
        }

        String answer = String.valueOf(inputChars);
        System.out.println(answer);

        reader.close();
    }

    private static Character encryptROT13(char[] alphabets, int index) {
        char alphabet = alphabets[index];

        if (!Character.isAlphabetic(alphabet)) {
            return alphabet;
        }

        char baseA = Character.isUpperCase(alphabet) ? 'A' : 'a';

        int moveIndex = (alphabet - baseA + 13) % 26;
        
        return (char)(moveIndex + baseA);
    }

}
