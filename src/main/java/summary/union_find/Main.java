package summary.union_find;


/**
 * @UnionFind_Algorithm 여러 노드가 존재할 때, 두 개의 노드를 선택해서, 현재 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘이다.
 * @Find Find(x) : x가 어떤 집합에 포함되어 있는지 찾는 연산
 * @Union(x,y) x와 y가 포함되어 있는 집합을 합치는 연산
 * @reference1 https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java-%EC%9C%A0%EB%8B%88%EC%98%A8-%ED%8C%8C%EC%9D%B8%EB%93%9CUnion-Find-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * @reference2 https://brenden.tistory.com/33
 */
public class Main {

    private static int[] parent;

    // union 연산
    public static boolean union(int x, int y) {
        x = find(x); // x 의 부모 노드 찾기
        y = find(y); // y 의 부모 노드 찾기

        // 이미 같은 그래프에 속해있을 때 false 반환
        if(x == y) {
            return false;
        }

        if(x <= y)  {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

        return true;
    }

    // find : x 노드의 부모 노드를 찾는 연산
    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }

    // parent 출력
    public static void parentPrint() {
        System.out.print("[ ");
        for (int i = 1; i < parent.length; i++) {
            System.out.print(parent[i]+ " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int n = 5;
        parent = new int[n + 1];

        // 부모 노드 초기화
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        //위의 예제 실행
        union(1, 2);
        parentPrint();

        union(3, 4);
        parentPrint();

        union(3, 5);
        parentPrint();

        System.out.println("find(2): " + find(2));
        System.out.println("find(4): " + find(4));

        union(2, 4);
        parentPrint();
        System.out.println("find(4): " + find(4));
    }

}
