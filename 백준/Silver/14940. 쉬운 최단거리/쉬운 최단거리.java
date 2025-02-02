
import java.util.*;
import java.io.*;

public class Main {
	static int[][] graph;
	static int[][] dist;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		graph = new int[n][m];
		dist = new int[n][m];

		for (int i=0; i<n; i++ ) {
			Arrays.fill(dist[i],-1);
		}

		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				int num =Integer.parseInt(st.nextToken());
				graph[i][j] = num;
				if(num == 2) {
					q.add(new int[] {i, j});
					dist[i][j] = 0;
				}
			}
		}

		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cx = current[0];
			int cy = current[1];

			for (int i=0; i<4; i++ ) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];

				if(nx>=0 && nx<n && ny>=0 && ny<m && graph[nx][ny] == 1 && dist[nx][ny] ==-1 ) {
					dist[nx][ny] = dist[cx][cy]+1;
					q.add(new int[]{nx,ny});
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for ( int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if(graph[i][j] == 0)
					sb.append(0).append(" ");
				else sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
