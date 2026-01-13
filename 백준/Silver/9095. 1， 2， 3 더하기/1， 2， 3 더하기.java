
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			dp = new int[k + 1];
			sb.append(dp(k)).append('\n');
		}

		System.out.println(sb);
	}

	static int dp(int k) {
		if (k <= 3) {
			if (k == 1) return 1;
			if (k == 2) return 2;
			return 4; // k == 3
		}
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i=4; i<=k; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}

		return dp[k];
	}
}
