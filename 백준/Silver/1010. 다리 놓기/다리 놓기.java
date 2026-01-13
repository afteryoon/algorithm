

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1010 - 다리 놓기
 * dp[n][m] = 동쪽 m개 중에서 서쪽 n개를 순서 유지하며 고르는 경우의 수
 * 점화식: dp[n][m] = dp[n][m-1] (m번째를 안 씀) + dp[n-1][m-1] (m번째를 씀)
 * 초기값: dp[0][m] = 1 (아무 것도 안 고르는 경우는 1가지)
 *        dp[n][n] = 1 (n개 중 n개 고르는 경우는 1가지)
 */
public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < test; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken());  // N
            int east = Integer.parseInt(st.nextToken());  // M

            dp = new int[west + 1][east + 1];
            sb.append(countBridges(west, east)).append('\n');
        }

        System.out.print(sb);
    }

    static int countBridges(int n, int m) {
        // dp[0][j] = 1: 서쪽 다리가 0개면(아무 것도 안 고르면) 경우의 수는 1
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 1;
        }

        // i는 서쪽(고를 개수), j는 동쪽(전체 후보)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == j) {
                    // j개 중 i(=j)개 전부 고르는 경우는 1가지
                    dp[i][j] = 1;
                } else if (i > j) {
                    // 후보(j)보다 고를 개수(i)가 많으면 불가능(0)
                    dp[i][j] = 0;
                } else {
                    // 핵심 점화식:
                    // 1) j번째(동쪽 m번째)를 안 쓰면: dp[i][j-1]
                    // 2) j번째를 쓰면: (i-1개를 j-1개에서 고르는) dp[i-1][j-1]
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }
}
