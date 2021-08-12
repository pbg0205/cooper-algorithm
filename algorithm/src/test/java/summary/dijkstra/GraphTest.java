package summary.dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

class GraphTest {
    private final int INF = 1_000_000;
    private Graph graph;

    @BeforeEach
    void beforeEach() {
        int size = 6;
        int[][] map = new int[][]{
                {0, 2, 5, 1, INF, INF},
                {2, 0, 3, 2, INF, INF},
                {5, 3, 0, 3, 1, 5},
                {1, 2, 3, 0, 1, INF},
                {INF, INF, 1, 1, 0, 2},
                {INF, INF, 5, INF, 2, 0}
        };

        graph = new Graph(size);
        graph.initMap(map);
    }

    @Test
    @DisplayName("시작 지점과 목표 지점의 가중치를 초기화한다.")
    void initMapTest() {
        int[][] map = new int[][]{
                {0, 2, 5, 1, INF, INF},
                {2, 0, 3, 2, INF, INF},
                {5, 3, 0, 3, 1, 5},
                {1, 2, 3, 0, 1, INF},
                {INF, INF, 1, 1, 0, 2},
                {INF, INF, 5, INF, 2, 0}
        };

        //then
        assertThat(graph.getMap()).isEqualTo(map);
    }

    @Test
    @DisplayName("시작 지점에서 부터 목표 지점까지의 최소 거리를 초기화한다.")
    void initDistanceTest() throws Exception {
        //given
        int start = 0;
        int[] controlDistance = new int[] {0, 2, 5, 1, INF, INF};

        //when
        Method distanceInit = graph.getClass().getDeclaredMethod("initDistance", int.class);
        distanceInit.setAccessible(true);
        distanceInit.invoke(graph, start);

        //then
        assertThat(graph.getDistance()).isEqualTo(controlDistance);
    }

    @Test
    @DisplayName("0번 인덱스의 최소거리 인덱스를 반환한다.")
    void getMinDistanceIndexTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        int minIndex = 3;
        int start = 0;

        //when
        Method initDistance = graph.getClass().getDeclaredMethod("initDistance", int.class);
        initDistance.setAccessible(true);
        initDistance.invoke(graph, start);

        Method calculateMinDistance = graph.getClass()
                .getDeclaredMethod("getMinDistanceIndex");
        calculateMinDistance.setAccessible(true);
        int current = (int)calculateMinDistance.invoke(graph);

        //then
        assertThat(current).isEqualTo(minIndex);
    }

    @Test
    @DisplayName("시작 지점에서 목표 지점까지의 최소 거리를 반환한다.")
    void dijkstraTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //given
        int start = 0;
        int[] controlDistance = new int[] {0, 2, 3, 1, 2, 4};

        //when
        Method dijkstraMethod = graph.getClass()
                .getDeclaredMethod("dijkstra", int.class);
        dijkstraMethod.invoke(graph, start);

        //then
        assertThat(graph.getDistance()).isEqualTo(controlDistance);
    }
}
