

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static char[][] board;
	static boolean[][] isVisited;
	static int n,m;
	static int[][] dp;
	static boolean infinite = false;

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = br.readLine().trim();
			for (int j = 0; j < m; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		isVisited = new boolean[n][m];
		dp = new int[n][m];
		for(int[] row : dp) { Arrays.fill(row, -1); }

		StringBuilder sb = new StringBuilder();
		int ans = dfs(0,0);
		sb.append(infinite ? -1 : ans);

		System.out.println(sb);

	}

	static int dfs(int r, int c) {

		if(r<0 || r>=n || c<0 || c>=m || board[r][c] == 'H') return 0;

		if(isVisited[r][c]) {
			infinite = true;
			return 0;
		}

		if(dp[r][c] != -1) return dp[r][c];

		isVisited[r][c] = true;
		int step = board[r][c] - '0';
		int best = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k] * step;
			int nc = c + dc[k] * step;
			best = Math.max(best, 1+dfs(nr, nc));
			if(infinite) break;
		}
		isVisited[r][c] = false;

		return dp[r][c] = best;
	}

}
