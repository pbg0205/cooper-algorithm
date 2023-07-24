package solved_problem.programmers.level02.스킬트리;

class Solution3 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            int matchIdx = 0;
            boolean enableSkillTree = true;

            for (char singleSkill : skillTree.toCharArray()) {
                int skillIdx = skill.indexOf(singleSkill);
                if (skillIdx == -1) {
                    continue;
                }

                if (skillIdx == matchIdx) {
                    matchIdx++;
                    continue;
                }

                enableSkillTree = false;
                break;
            }

            if (enableSkillTree)
                answer++;
        }
        return answer;
    }

}

/**
 *  테스트 1 〉	통과 (0.05ms, 73.6MB)
 *  테스트 2 〉	통과 (0.02ms, 73MB)
 *  테스트 3 〉	통과 (0.04ms, 73.9MB)
 *  테스트 4 〉	통과 (0.02ms, 73.6MB)
 *  테스트 5 〉	통과 (0.05ms, 74.3MB)
 *  테스트 6 〉	통과 (0.03ms, 74.8MB)
 *  테스트 7 〉	통과 (0.03ms, 76.1MB)
 *  테스트 8 〉	통과 (0.03ms, 80MB)
 *  테스트 9 〉	통과 (0.05ms, 75.5MB)
 *  테스트 10 〉	통과 (0.04ms, 74.9MB)
 *  테스트 11 〉	통과 (0.04ms, 76.7MB)
 */
