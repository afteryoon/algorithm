
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n+1];
		int[] dp = new int[n+1];
		dp[0]=0;
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i-1] + nums[i];
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			sb.append(dp[end]-dp[start-1]).append("\n");
		}
		System.out.print(sb);
	}
}
