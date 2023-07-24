package solved_problem.programmers.level02.스킬트리;

class Solution2 {

    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        for (String skillTree : skill_trees) {
            String neededSkill = skillTree.replaceAll("[^" + skill + "]", "");
            if (skill.startsWith(neededSkill)) {
                count++;
            }
        }

        return count;
    }

}

/**
 *  테스트 1 〉	통과 (7.60ms, 74.1MB)
 *  테스트 2 〉	통과 (8.41ms, 70.8MB)
 *  테스트 3 〉	통과 (9.61ms, 77.9MB)
 *  테스트 4 〉	통과 (6.47ms, 74MB)
 *  테스트 5 〉	통과 (6.85ms, 77.7MB)
 *  테스트 6 〉	통과 (9.40ms, 75.7MB)
 *  테스트 7 〉	통과 (6.72ms, 77.2MB)
 *  테스트 8 〉	통과 (6.84ms, 82.4MB)
 *  테스트 9 〉	통과 (8.64ms, 78MB)
 *  테스트 10 〉	통과 (8.98ms, 77.8MB)
 *  테스트 11 〉	통과 (9.71ms, 73.3MB)
 *  테스트 12 〉	통과 (9.70ms, 76.4MB)
 *  테스트 13 〉	통과 (6.70ms, 84.1MB)
 *  테스트 14 〉	통과 (6.36ms, 76.2MB)
 */
