package ch04_data_structure.array_and_list;

import java.util.Scanner;

/**
 * 숫자의 합
 * 문제: N개의 숫자가 공백 없이 쓰여 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오.
 *
 * 입력:
 *     첫쨰 줄: 숫자의 개수 N (1 ≤ N ≤ 100)
 *     둘째 줄: N개의 숫자가 공백 없이 주어진다
 *
 *     출력: 입력으로 주어진 N개 숫자의 합
 *
 * 예시:
 *     입력: 5 / 54321
 *     출력: 15
 */

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 입력값을 String형 변수 sNum에 저장한 . char[]형 변수로 변환하기
        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;
        for (int i = 0; i < cNum.length; i++) {
            sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }
        System.out.print(sum);
    }
}
