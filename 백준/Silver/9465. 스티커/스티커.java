
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());

        while(t-->0){ //test case만큼 반복
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            // 배열생성
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값 설정 맨 처음 수는 자기 자신임
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            if (n > 1) { //대각선 방향의 수와 합이 두번째 수임
                dp[0][1] = arr[1][0] + arr[0][1];
                dp[1][1] = arr[0][0] + arr[1][1];
            }

            // 대각선 방향과 그 전 값을 비교
            for (int j = 2; j <n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }

            // 최대 점수 출력 -마지막 칸에서 1행과 2향 비교
            System.out.println(Math.max(dp[0][n - 1], dp[1][n - 1]));
        }
    }

}
