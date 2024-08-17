
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int c0;
	static int c1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb= new StringBuilder();

		int[][] dp = new int[41][2];
		dp[0][0]=1; //0번 횟수
		dp[0][1]=0; //1번 횟수
		dp[1][0]=0;
		dp[1][1]=1;

		for (int i = 2; i < dp.length; i++) {
			dp[i][0]= dp[i-1][0] + dp[i-2][0];
			dp[i][1]= dp[i-1][1] + dp[i-2][1];
		}

		for (int i = 0; i < n; i++) {
			int m = Integer.parseInt(br.readLine());
			sb.append(dp[m][0]).append(" ").append(dp[m][1]).append("\n");
		}

		System.out.println(sb);
	}
}
