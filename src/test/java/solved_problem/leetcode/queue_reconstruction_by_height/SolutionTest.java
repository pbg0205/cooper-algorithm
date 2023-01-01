package solved_problem.leetcode.queue_reconstruction_by_height;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class SolutionTest {
    private int[][] people;
    private final Solution solution = new Solution();

    @BeforeEach
    void setUp() {
        people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    }

    @Test
    @DisplayName("문제 결과를 반환한다.")
    void reconstructQueue() {
        //given
        int[][] answer = new int[][]{{5, 0},{7, 0},{5, 2},{6, 1},{4, 4},{7, 1}};

        //when
        int[][] result = solution.reconstructQueue(people);

        //then
        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("키가 큰 순으로 정렬하고 같을 시, 앞에 키 큰 사람이 적은 순으로 정렬한다.")
    void sortByHeightAndNumberOfTallerPeople() throws Exception {
        //given
        int[][] answer = new int[][]{{7, 0},{7, 1},{6, 1},{5, 0},{5, 2},{4, 4}};

        //when
        Method method = solution.getClass()
                .getDeclaredMethod("sortByHeightAndNumberOfTallerPeople", int[][].class);
        method.setAccessible(true);
        method.invoke(solution, (Object) people);

        //then
        assertThat(people).isEqualTo(answer);
    }
}
