

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n + 1];

		if(n == 1) { System.out.println(0); return; }
		if(n == 2) { System.out.println(1); return; }

		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 1] + 1;
			if(i % 2 == 0) { dp[i] = Math.min(dp[i], dp[i / 2] + 1); }
			if(i % 3 == 0) { dp[i] = Math.min(dp[i], dp[i / 3] + 1); }
		}

		System.out.println(dp[n]);
	}
}
