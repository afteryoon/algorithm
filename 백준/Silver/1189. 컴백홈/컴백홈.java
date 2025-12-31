
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,m,k;
	static boolean[][] isVisit;
	static char[][] map;
	static int ans;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 k = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		isVisit = new boolean[n][m];

		 for (int i = 0; i < n; i++) {
			 map[i] = br.readLine().toCharArray();
		 }

		 dfs(n - 1, 0, 1);

		 StringBuilder sb = new StringBuilder();
		 sb.append(ans);
		 System.out.println(sb);
	}

	static void dfs(int cx, int cy, int dist) {
		if (cx == 0 && cy == m - 1) {
			if (dist == k) ans++;
			return;
		}
		if (dist >= k) return;
		isVisit[cx][cy] = true;

		for (int i = 0; i < 4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];
			if(nx >= 0 && nx<n && ny>=0 && ny<m && map[nx][ny] != 'T' && !isVisit[nx][ny] ) {
				dfs(nx,ny,dist+1);
			}
		}
		isVisit[cx][cy] = false;
	}
}
