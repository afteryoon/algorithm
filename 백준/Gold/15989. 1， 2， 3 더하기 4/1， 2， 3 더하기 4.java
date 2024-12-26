

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int max = 10001;
	static int[][] dp = new int[max][4];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		createDP();

		for (int i = 0; i < N; i++) {
			int s = Integer.parseInt(br.readLine());
			System.out.println(dp[s][1] + dp[s][2] + dp[s][3]);
		}
	}

	public static void createDP() {

		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		for( int i = 4; i < max; i++) {
			dp[i][1] = dp[i-1][1];
			dp[i][2] = dp[i-2][1] + dp[i-2][2];
			dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
		}

	}
}
