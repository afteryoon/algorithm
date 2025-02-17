
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+1];

		if(n == 1) {
			System.out.print(0);
			return;
		}

		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] +1;

			if(i%3 == 0) dp[i] = Math.min(dp[i/3]+1, dp[i]);
			if(i%2 == 0) dp[i] = Math.min(dp[i/2]+1, dp[i]);
		}

		System.out.print(dp[n]);
	}
}
