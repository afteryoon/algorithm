
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1932 - 정수 삼각형
 *
 * dp[j] = "현재 행"에서 j번째 칸에 도착했을 때의 최대 합
 * (아래로 내려오면서 dp를 갱신해 나가는 1차원 DP)
 *
 * 마지막 행동 분해(위에서 내려오는 두 경우):
 *  - 왼쪽 위에서 내려옴: prev[j-1]
 *  - 오른쪽 위에서 내려옴: prev[j]
 *
 * 경계:
 *  - j==0   : 오른쪽 위(prev[0])만 가능
 *  - j==i   : 왼쪽 위(prev[i-1])만 가능
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] prev = new int[n]; // 이전 행 dp
        int[] cur = new int[n];  // 현재 행 dp

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j <= i; j++) {
                int val = Integer.parseInt(st.nextToken());

                if (i == 0) {
                    // 첫 행은 그대로 시작
                    cur[j] = val;
                } else if (j == 0) {
                    // 맨 왼쪽: 오른쪽 위(prev[0])에서만 내려올 수 있음
                    cur[j] = prev[j] + val;
                } else if (j == i) {
                    // 맨 오른쪽: 왼쪽 위(prev[i-1])에서만 내려올 수 있음
                    cur[j] = prev[j - 1] + val;
                } else {
                    // 가운데: 두 후보 중 최대
                    cur[j] = Math.max(prev[j - 1], prev[j]) + val;
                }
            }

            // 다음 행 계산을 위해 prev <- cur 복사(스왑)
            int[] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        int ans = 0;
        for (int x : prev) {
            ans = Math.max(ans, x);
        }

        System.out.println(ans);
    }
}
