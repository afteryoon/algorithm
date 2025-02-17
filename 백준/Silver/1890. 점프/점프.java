

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		long[][] dp = new long[n][n];

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = 1;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(dp[i][j] == 0 || map[i][j] == 0) continue;

				int jump = map[i][j];
				if(j + jump < n) {
					dp[i][j + jump] += dp[i][j];
				}
				if(i + jump < n) {
					dp[i + jump][j] += dp[i][j];
				}
			}
		}

		System.out.println(dp[n-1][n-1]);
	}
}
