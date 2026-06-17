package ch04_data_structure.array_and_list;

import java.io.IOException;
import java.util.Scanner;

/**
 * 나머지 . 구하기
 * 문제: N개의 수 A1, A2, ...An이 주어졌을 때 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
 * 즉, Ai + ... + Aj(i ≤ j)의 합이 M으로 나누어떨어지는 (i, j) 쌍의 개수를 구하시오.
 *
 * 입력:
 *     1번째 줄에 N과 M(1 ≤ N ≤ 10^6, 2 ≤ M ≤ 10^3), 2번째 줄에 N개의 수 A1, A2, ..., An이 주어진다
 *     (0 ≤ Ai ≤ 10^9)
 *
 *     출력: 1번쨰 줄에 연속된 부분의 합이 M으로 나누어떨어지는 구간의 개수를 출력한다.
 *
 * 예시:
 *     입력: 5 / 54321
 *     출력: 15
 */


public class SumWithModulo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long[] S = new long[N];
        long[] C = new long[M];
        long answer = 0;

        // 수열 합 배열 만들기
        S[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + sc.nextInt();
        }

        // 합 배열의 모든 값에 % 연산 수행하기
        for (int i = 0; i < N; i++) {
            int remainder = (int) (S[i] % M);

            // 0 ~ i 까지의 구간 합 자체가 M의 배수일 때 정답에 더하기
            if (remainder == 0) answer++;

            // 나머지가 같은 인덱스의 개수 카운팅하기
            C[remainder]++;
        }

        // 나머지가 같은 인덱스 2개를 뽑는 경우의 수를 더하기
        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}