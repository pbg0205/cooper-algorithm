package solved_problem.programmers.kakao_blind_recuitment_2021;

class Solution {

	public String solution(String new_id) {
		//step-1
		new_id = new_id.toLowerCase();

		//step-2
		new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");

		// 특정 특수 문자를 지우는 정규식
		// new_id = new_id.replaceAll("[!@#*]", "");


		//step-3
		new_id = new_id.replaceAll("\\.+", ".");

		//step-4
		new_id = new_id.replaceAll("^\\.+|\\.+$", "");

		//step-5
		if (new_id.isEmpty()) {
			new_id = "a";
		}

		//step-6
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			new_id = new_id.replaceAll("\\.$", "");
		}

		//step-7
		while (new_id.length() < 3) {
			new_id += new_id.charAt(new_id.length() - 1);
		}

		return new_id;
	}

}
