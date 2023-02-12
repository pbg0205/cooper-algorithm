package solved_problem.baekjoon.덩치_7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        personInfo[] arr = new personInfo[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i] = new personInfo(weight, height);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[i].weight > arr[j].weight) {
                    if (arr[i].height > arr[j].height) {
                        arr[j].addCount();
                    }
                }
            }
        }

        for (personInfo person : arr) {
            System.out.print(person.count + " ");
        }

        br.close();
    }
}

class personInfo {
    int weight;
    int height;
    int count;

    personInfo(int weight, int height) {
        this.weight = weight;
        this.height = height;
        count++;
    }

    public void addCount() {
        this.count += 1;
    }
}

