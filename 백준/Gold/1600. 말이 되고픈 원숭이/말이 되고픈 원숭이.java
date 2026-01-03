
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n,m,k;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dx = {-1, 0, 1, 0 };
	static int[] dy = {0, 1, 0, -1 };
	static int[] hx = {-1, -1, 1, 1, 2, 2, -2, -2};
	static int[] hy = {-2, 2, -2, 2, -1, 1, -1, 1};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); 
		n = Integer.parseInt(st.nextToken()); 

		map = new int[n][m];
		visited = new boolean[n][m][k+1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0, 0 ,0});
		visited[0][0][0] = true;
		StringBuilder sb = new StringBuilder();

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int count = cur[2];
			int dist = cur[3];

			if(x== n-1 && y== m-1){
					sb.append(dist);
					System.out.println(sb);
					return;
			}

			for(int i=0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if(nx >=0 && nx<n && ny>= 0 && ny<m && map[nx][ny] == 0 &&!visited[nx][ny][count]) {
					visited[nx][ny][count] = true;
					q.add(new int[]{nx, ny, count, dist+1});
				}
			}
			if(count < k) {
				for (int i = 0; i < 8; i++) {
					int nx = cur[0] + hx[i];
					int ny = cur[1] + hy[i];
					if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0 && !visited[nx][ny][count+1]) {
						visited[nx][ny][count+1] = true;
						q.add(new int[] {nx, ny, count + 1 , dist+1});
					}
				}
			}

		}

		sb.append(-1);
		System.out.println(sb);
	}
}
