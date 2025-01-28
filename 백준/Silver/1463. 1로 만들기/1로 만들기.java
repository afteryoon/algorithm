import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.print(dp(n));

	}

	public static int dp(int n){
		if( n == 1)
			return 0;

		int[] dp = new int[n + 1];

		for (int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1;

			if(i%2==0)
				dp[i] = Math.min(dp[i],dp[i/2]+1);
			if(i%3==0)
				dp[i] = Math.min(dp[i],dp[i/3]+1);
		}

		return dp[n];
	}
}
