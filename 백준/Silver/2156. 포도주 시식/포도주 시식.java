
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 2156 - 포도주 시식
 * 규칙: 연속 3잔을 마실 수 없음
 *
 * dp[i] = 1~i번째 잔까지 고려했을 때 마실 수 있는 최대 양
 *
 * 마지막 행동 분해(세 가지):
 *  1) i번째 잔을 안 마신다               -> dp[i-1]
 *  2) i번째 잔만 마신다( i-1은 안 마심 )  -> dp[i-2] + wine[i]
 *  3) i-1, i를 연속으로 마신다( i-2는 안 마심 ) -> dp[i-3] + wine[i-1] + wine[i]
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wine = new int[n + 1]; // 1-index
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wine[1]);
            return;
        }

        long[] dp = new long[n + 1];
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    Math.max(
                            dp[i - 2] + wine[i],
                            dp[i - 3] + wine[i - 1] + wine[i]
                    )
            );
        }

        System.out.println(dp[n]);
    }
}
