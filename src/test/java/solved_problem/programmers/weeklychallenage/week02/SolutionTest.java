package solved_problem.programmers.weeklychallenage.week02;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    void test01() {
        //given
        int[][] scores = new int[][]{
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}
        };
        String expected = "FBABD";

        //when
        String result = this.solution.solution(scores);

        //then
        assertThat(result).isEqualTo(expected);
    }
    
    @Test
    void averageMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        int[][] scores = new int[][]{
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}
        };

        double[] expected = new double[]{45.5, 81.25, 97.2, 81.6, 67.8};

        //when
        Method getAverages = solution.getClass().getDeclaredMethod("getAverages", int[][].class);
        getAverages.setAccessible(true);
        double[] result = (double[]) getAverages.invoke(solution, (Object) scores);

        //then
        assertThat(expected).isEqualTo(result);
    }
}
