

import java.util.*;
import java.io.*;

public class Main {
	static int n,m,k;
	static int[][][] dist;
	static int[][] map;
	static int[] dy ={0,0,1,-1};
	static int[] dx ={1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dist = new int[n][m][k+1];
		map = new int[n][m];

		for (int i=0; i<n; i++) {
			String str = br.readLine();
			for (int j=0; j<m; j++) {
				map[i][j] = str.charAt(j)-'0';
				for (int l=0; l<=k; l++){
					dist[i][j][l] = -1;
				}
			}
		}

		Queue<int[]> q = new LinkedList<>();
		dist[0][0][0] = 1;
		q.add(new int[]{0,0,0});

		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int broken = current[2];

			if(x == n-1 && y == m-1) {
				System.out.print(dist[x][y][broken]);
				return;
			}

			for (int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];

				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

				if(broken < k && dist[nx][ny][broken+1] == -1 && map[nx][ny] == 1) {
					q.add(new int[]{nx,ny,broken+1});
					dist[nx][ny][broken+1] = dist[x][y][broken] + 1;
				} else if(map[nx][ny] == 0 && dist[nx][ny][broken] == -1) {
					q.add(new int[] {nx,ny,broken});
					dist[nx][ny][broken] = dist[x][y][broken] + 1;
				}
			}

		}

		System.out.print(-1);
	}
}
