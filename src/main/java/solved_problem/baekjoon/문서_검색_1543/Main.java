package solved_problem.baekjoon.문서_검색_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String document = reader.readLine();
		String searchingWord = reader.readLine();

		int count = 0;

		for (int idx = 0; idx < document.length() - searchingWord.length() + 1; idx++) {
			if (document.charAt(idx) != searchingWord.charAt(0)) {
				continue;
			}

			if (matchesWord(document, searchingWord, idx)) {
				idx += searchingWord.length() - 1;
				count++;
			}

		}

		System.out.println(count);

		reader.close();
	}

	private static boolean matchesWord(String document, String searchingWord, int currentIdx) {
		int startIdx = currentIdx;
		int endIdx = (currentIdx + searchingWord.length()) >= document.length() ?
			document.length() :
			currentIdx + searchingWord.length();

		return document.substring(startIdx, endIdx).equals(searchingWord);
	}

}
