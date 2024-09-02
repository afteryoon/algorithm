
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dy={0,1,-1,0};
	static int[] dx={-1,0,0,1};
	static int[][] map;
	static boolean[][] visit;
	static int[][] dp;
	static int col,row;
	// static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		// visit = new boolean[col][row];
		dp = new int[col][row];

		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}


		System.out.println(dfs(0,0));
	}

	private static int dfs(int y, int x) {
		//visit[y][x] = true;
		if (y==col-1 && x==row-1)
			return 1;
		if (dp[y][x] != -1) return dp[y][x];

		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int ny = y+dy[i];
			int nx = x+dx[i];

			if (ny>=0 && nx>=0 && ny<col && nx<row
				 && map[y][x]>map[ny][nx]){
				dp[y][x] += dfs(ny, nx);
			}
		}

		return dp[y][x];
	}
}
