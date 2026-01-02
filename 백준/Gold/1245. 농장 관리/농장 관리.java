

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] graph;
	static boolean[][] isVisit;

	static int[] dx = {-1, 1, 0, 0,-1,1,1,-1};
	static int[] dy = {0, 0, -1, 1,-1,1,-1,1};
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new int[n][m];
		isVisit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!isVisit[i][j]) {
					flag = true;
					dfs(i,j);
					if(flag)ans++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		System.out.println(sb);
	}

	static void dfs(int cx, int cy) {
		isVisit[cx][cy] = true;

		for (int d = 0; d < 8; d++) {
			int nx = cx + dx[d];
			int ny = cy + dy[d];
			if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
				if (!isVisit[nx][ny] && graph[nx][ny] == graph[cx][cy]) {
					dfs(nx, ny);
				}
				if (graph[cx][cy] < graph[nx][ny]) {
					flag = false;
				}
			}
		}

	}
}
