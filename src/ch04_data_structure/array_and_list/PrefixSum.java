package ch04_data_structure.array_and_list;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N * N 개의 수가 N x N 크기의 표에 채워져 있다. 표 안의 . 중 (X1, Y1)에서 (X2, Y2)까지의 합을 구하려 한다.
 * X는 행, Y는 열을 의미한다. 예를 들어 N = 4이고, 표가 다음과 같이 채워져 있을 떄를 살펴보자. (2, 2)에서 (3, 4)
 * 까지의 합을 구하면 3 + 4 + 5 + 4 + 5 + 6 = 27이고, (4, 4)에서 (4, 4)까지의 합을 구하면 7이다. 표에
 * 채워져 있는 수와 합을 구하는 연산이 주어졌을 때 이를 처리하는 프로그램을 작성하시오.
 *
 * 입력:
 *     1번쨰 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다 (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
 *     2번째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다. 다음 M개의 줄에는 4개의 정수
 *     X1, Y1, X2, Y2가 주어지며, (X1, Y1)에서 (X2, Y2)의 합을 구해 출력해야 한다. 표에 채워져 있는
 *     수는 1,000보다 작거나 같은 자연수다 (X1 ≤ X2, Y1 ≤ Y2)
 *
 * 출력:
 *     총 M줄에 걸쳐 (X1, Y1)에서 (X2, Y2)까지 합을 구해 출력한다.
 *
 * 예시:
 *     4 3        // 2차원 배열의 크기, 구간 합 질의의 개수
 *     1 2 3 4    // 원본 배열 1번쨰 줄
 *     2 3 4 5    // 원본 배열 2번쨰 줄
 *     3 4 5 6    // 원본 배열 3번째 줄
 *     4 5 6 7    // 원본 배열 4번째 줄
 *     2 2 3 4    // 구간 합 (X1, Y1), (X2, Y2) 1번쨰 질의
 *     3 4 3 4    // 구간 합 (X1, Y1), (X2, Y2) 2번쨰 질의
 *     1 1 4 4    // 구간 합 (X1, Y1), (X2, Y2) 1번쨰 질의
 *
 */
public class PrefixSum {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int D[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                //구간 합 구하기
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // 구간 합 배열로 질의에 답변하기
            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println(result);
        }
    }
}
