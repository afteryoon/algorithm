

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2579 - 계단 오르기
 * 규칙:
 *  - 한 번에 1칸 또는 2칸 이동
 *  - 연속된 3개의 계단을 모두 밟을 수 없음
 *  - 마지막 계단은 반드시 밟아야 함
 *
 * dp[i] = i번째 계단(1-index)을 "반드시 밟는" 상태에서 얻을 수 있는 최대 점수
 * 점화식(마지막 행동 분해):
 *  1) i-2에서 2칸 점프해서 i를 밟는다: dp[i-2] + score[i]
 *  2) i-3 -> i-1 -> i (연속 2칸 밟기) : dp[i-3] + score[i-1] + score[i]
 * 따라서
 *  dp[i] = max(dp[i-2], dp[i-3] + score[i-1]) + score[i]
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n + 1]; // 1-index
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(score[1]);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + score[i - 1]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
