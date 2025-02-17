

import java.io.*;
import java.util.*;

public class Main {
	static int[][] sum, arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int test = Integer.parseInt(st.nextToken());

		arr = new int[n+1][n+1];
		sum = new int[n+1][n+1];

		for (int i=1; i<=n; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=n; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + arr[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i=0; i<test; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			sb.append(check(x1,y1,x2,y2)).append("\n");
		}

		System.out.print(sb);
	}

	public static int check(int x1, int y1, int x2, int y2) {

		return sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
	}
}
