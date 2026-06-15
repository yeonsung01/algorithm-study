package ch04_data_structure.array_and_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.
 *
 *
 * 입력:
 *     1번째 줄에 수의 개수 N(1 ≤ N ≤ 100,000), 합을 구해야 하는 횟수 M(1 ≤ M ≤ 100,000), 2번째 줄에
 *     N개의 수가 주어진다. 각 수는 1,000보다 작거나 같은 자연수다. 3번째 줄부터는 m개의 줄에 합을 구해야 하는 구간
 *     i 와 j가 주어진다.
 *
 * 출력:
 *     총 M개의 줄에 입력으로 주어진 i번째 수에서 j번째 수까지의 합을 출력한다.
 *
 * 예시:
 *.    5 3               // 데이터의 개수, 질의 개수
 *     5 4 3 2 1         // 구간 합을 구할 대상 배열
 *     1 3
 *     2 4
 *     5 5
 *
 * 예제 출력:
 *         12
 *         9
 *         1
 */


public class PrefixSum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 수의 개수
        int m = Integer.parseInt(st.nextToken()); // 쿼리 개수

        // 누적합 배열 생성
        long[] prefixSum = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < m; q++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(prefixSum[right] - prefixSum[left - 1]).append("\n");
        }
        System.out.print(sb);
    }
}