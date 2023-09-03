package solved_problem.baekjoon.행렬_1080;

import java.util.Scanner;

class Main {
    static int N;			// 행
    static int M;			// 열
    static int[][] aArr;	// 행렬 A
    static int[][] bArr;	// 행렬 B
    static int count = 0;	// 연산의 횟수

    // 3*3 부분 행렬의 모든 원소 뒤집기(0->1, 1->0)
    public static boolean reverseArr(int row, int col){

        // 전달받은 인덱스 i, j가 변환할 범위를 벗어날때
        if(row+3 > N || col+3 > M)
            return false;

        for(int i=row; i<row+3; i++) {
            for(int j=col; j<col+3; j++) {
                if(aArr[i][j] == 0)
                    aArr[i][j] = 1;
                else
                    aArr[i][j] = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        aArr = new int[N][M];
        bArr = new int[N][M];

        for(int i=0; i<N; i++) {
            String str = scan.next();
            for(int j=0; j<M; j++)
                aArr[i][j] = str.charAt(j) - '0';
        }
        for(int i=0; i<N; i++) {
            String str = scan.next();
            for(int j=0; j<M; j++)
                bArr[i][j] = str.charAt(j) - '0';
        }

        // (0,0)부터 원소를 일일이 비교해가며 다를경우 reverseArr 메서드를 통해 원소 뒤집음.
        // 3*3 크기의 행렬이 고정이므로, 범위를 벗어날 떄까지 같지않을경우, -1 출력
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(aArr[i][j] != bArr[i][j]) {
                    if(reverseArr(i, j)) {
                        count ++;
                    } else {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(count);
        scan.close();
    }
}
