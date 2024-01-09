package solved_problem.programmers.level01.붕대감기;

class Solution {

	// 붕대 감기는 t 초 마다 x 만큼 회복된다.
	// 만약 t초를 모두 회복하면 y 만큼 추가 회복 된다.
	// 몬스터한테 맞으면 회복은 멈춘다.
	// 몬스터한테 맞으면 체력을 떨어진다.
	// 체력이 0 이하가 되면 캐릭터는 죽는다.
	public int solution(int[] bandage, int health, int[][] attacks) {
		int prevAttackTime = 0;
		int currentHealth = health;
		for (int[] attack : attacks) {
			int attackTime = attack[0];
			int damage = attack[1];

			int recoveryPerSecond = bandage[1];
			int recoveryTime = bandage[0];
			int additionalRecovery = bandage[2];

			int restTime = attackTime - prevAttackTime - 1;
			int recovery = restTime * recoveryPerSecond;
			int totalAdditionalRecovery = (restTime / recoveryTime) * additionalRecovery;

			int totalRecovery = recovery + totalAdditionalRecovery;
			currentHealth = getCurrentHealth(currentHealth, totalRecovery, health);

			prevAttackTime = attackTime;
			currentHealth -= damage;

			if (currentHealth <= 0) {
				return -1;
			}
		}

		return currentHealth;
	}

	private int getCurrentHealth(int currentHealth, int totalRecovery, int health) {
		return (currentHealth + totalRecovery >= health) ? health : currentHealth + totalRecovery;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// int result = solution.solution(new int[] {5, 1, 5}, 30, new int[][] {{2, 10}, {9, 15}, {10, 5}, {11, 5}});
		// int result = solution.solution(new int[] {3, 2, 7}, 20, new int[][] {{1, 15}, {5, 16}, {8, 6}});
		// int result = solution.solution(new int[] {4, 2, 7}, 20, new int[][] {{1, 15}, {5, 16}, {8, 6}});
		int result = solution.solution(new int[] {1, 1, 1}, 5, new int[][] {{1, 2}, {3, 2}});

		System.out.println("result = " + result);
	}
}
