
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		for(int i=0; i<test; i++) {
			int k = Integer.parseInt(br.readLine());
			System.out.println(dp(k));
		}
	}

	public static long dp(int k) {
		if(k <= 3) {
			return 1;
		}
		long[] dp = new long[k+1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for(int i=4; i<=k; i++) {
			dp[i] = dp[i-3]+dp[i-2];
		}
		return dp[k];
	}
}
