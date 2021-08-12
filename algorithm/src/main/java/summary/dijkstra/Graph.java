package summary.dijkstra;

class Graph {
    private static final int INF = 100000;

    private final int size;
    private final int[][] map;
    private final boolean[] visited;
    private final int[] distance;

    public Graph(int size) {
        this.size = size;
        this.map = new int[size][size];
        this.visited = new boolean[size];
        this.distance = new int[size];
    }

    public void initMap(int[][] map) {
        for (int row = 0; row < size; row++) {
            initColumnInMap(row, map);
        }
    }

    private void initColumnInMap(int row, int[][] mapRow) {
        for (int col = 0; col < size; col++) {
            this.map[row][col] = mapRow[row][col];
        }
    }

    private void initDistance(int start) {
        for (int goal = 0; goal < size; goal++) {
            distance[goal] = map[start][goal];
        }
        visited[start] = true;
    }

    public void dijkstra (int start) {
        initDistance(start);
        searchMinDistanceFromSmallIndex();
    }

    private void searchMinDistanceFromSmallIndex() {
        for (int i = 0; i < size; i++) {
            int current = getMinDistanceIndex();
            calculateMinDistance(current, size);
        }
    }

    private int getMinDistanceIndex() {
        int min = INF;
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (distance[i] < min && !visited[i]) {
                min = distance[i];
                index = i;
            }
        }
        return index;
    }

    private void calculateMinDistance(int current, int size) {
        visited[current] = true;

        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                if (distance[current] + map[current][i] < distance[i]) {
                    distance[i] = distance[current] + map[current][i];
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("distance[" + i + "] = " + distance[i]);
        }
    }

    public int[][] getMap() {
        return this.map;
    }

    public int[] getDistance() {
        return distance;
    }
}
