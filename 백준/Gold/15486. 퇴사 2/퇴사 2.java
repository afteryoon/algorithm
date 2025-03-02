

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] dp = new int[n+2];
		int[] days = new int[n+1]; // 변수명 일치시킴
		int[] money = new int[n+1];

		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			days[i] = Integer.parseInt(st.nextToken()); // days로 수정
			money[i] = Integer.parseInt(st.nextToken());
		}

		// DP 계산
		for(int i=n; i>=1; i--) {
			int nextDay = i + days[i];

			if(nextDay <= n+1) {
				dp[i] = Math.max(money[i] + dp[nextDay], dp[i+1]);
			} else {
				dp[i] = dp[i+1];
			}
		}

		System.out.println(dp[1]);
	}
}
