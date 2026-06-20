package ch04_data_structure.twopointer;

import java.util.Scanner;

/**
 * 어떠한 자연수 N은 하나 이상의 연속된 자연수의 합으로 나타낼 수 있다. 예를 들어 15를 나타내는 방법은
 * 15, 7 + 8, 4 + 5 + 6, 1 + 2 + 3 + 4 + 5이다. 반면, 10을 나타내는 방법은 10, 1 + 2 + 3 + 4 이다.
 * 자연수 N( 1 ≤ N ≤ 10,000,000)이 주어졌을 때, N을 연속된 자연수의 합으로 나타내는 가짓수를 출력하는 프로그램을 작성하시오.
 *
 * 입력:
 *     첫번째 줄에 자연수 N이 주어진다.
 *
 * 출력:
 *     입력된 자연수 N을 연속된 자연수의 합으로 나타내는 가짓수를 출력한다.
 *
 * 예시:
 *     입력: 15 //N
 *     출력: 4
 */
public class ConsecutiveSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum == N) {         // 현재 연속 합이 N과 같은 경우
                end_index++;
                sum = sum + end_index;
            } else if (sum > N) {   // 현재 연속 합이 N보다 더 큰 경우
                sum = sum - start_index;
                start_index++;
            } else {
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
