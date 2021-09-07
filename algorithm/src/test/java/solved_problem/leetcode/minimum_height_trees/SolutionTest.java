package solved_problem.leetcode.minimum_height_trees;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static org.assertj.core.api.Assertions.*;


class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testCase1() {
        //given
        int n = 6;
        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        List<Integer> result = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};
        //when
        List<Integer> minHeightTrees = solution.findMinHeightTrees(n, edges);

        //then
        assertThat(minHeightTrees).isEqualTo(result);
    }

    @Test
    @DisplayName("initMap 메서드 정상작동 확인")
    void initMapTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        Map<Integer, Set<Integer>> expected = initExpectedMap();

        //when
        Method privateMethod = solution.getClass().getDeclaredMethod("initMap", int[][].class);
        privateMethod.setAccessible(true);
        Object result = privateMethod.invoke(solution, (Object) edges);

        //then
        assertThat((Map<Integer,Set<Integer>>)result).isEqualTo(expected);
    }

    @Test
    @DisplayName("리프 노드를 저장 테스트")
    void initLeaveSet() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        //given
        int[][] edges = new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};
        Map<Integer, Set<Integer>> map = initExpectedMap();
        Set<Integer> expectedSet = initLeave();

        //when
        Method privateMethod = solution.getClass().getDeclaredMethod("initLeaves",
                Map.class);
        privateMethod.setAccessible(true);
        Object result = privateMethod.invoke(solution, map);

        //then
        assertThat(result).isEqualTo(expectedSet);
    }

    private Map<Integer, Set<Integer>> initExpectedMap() {
        Map<Integer, Set<Integer>> expected = new HashMap<>();

        expected.put(0, new HashSet<>());
        expected.put(1, new HashSet<>());
        expected.put(2, new HashSet<>());
        expected.put(3, new HashSet<>());
        expected.put(4, new HashSet<>());
        expected.put(5, new HashSet<>());

        expected.get(0).add(3);
        expected.get(3).add(0);

        expected.get(3).add(1);
        expected.get(1).add(3);

        expected.get(3).add(2);
        expected.get(2).add(3);

        expected.get(3).add(4);
        expected.get(4).add(3);

        expected.get(5).add(4);
        expected.get(4).add(5);

        return expected;
    }

    private Set<Integer> initLeave() {
        return new HashSet<Integer>() {{
            add(0);
            add(1);
            add(2);
            add(5);
        }};
    }
}
