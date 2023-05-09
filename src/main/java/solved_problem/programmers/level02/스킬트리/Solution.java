package solved_problem.programmers.level02.스킬트리;

import java.util.Arrays;

class Solution {

    // ^[BCD] : B, C, D 를 제외한 chracter 하나
    public int solution(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees)
                .map(skillTree -> skillTree.replaceAll("[^" + skill + "]", ""))
                .filter(skill::startsWith)
                .count();
    }

}
