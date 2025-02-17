

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	static int[][] map,dist;
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n == 0 ) break;
			count++;
			map = new int[n][n];
			dist = new int[n][n];

			for (int i=0; i<n; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(dist[i],Integer.MAX_VALUE);
				for (int j=0; j<n; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]>  q = new LinkedList<>();
			q.add(new int[]{0,0});
			dist[0][0] = map[0][0];

			while(!q.isEmpty()) {
				int[] current = q.poll();
				int x = current[0];
				int y = current[1];

				for(int j=0; j<4; j++) {
					int nx = x+dx[j];
					int ny = y+dy[j];

					if(nx<0 || nx>=n || ny<0 || ny>= n) continue;

					if(dist[x][y]+map[nx][ny] < dist[nx][ny] ) {
						q.add(new int[]{nx,ny});
						dist[nx][ny] = dist[x][y]+map[nx][ny];
					}
				}
			}
			sb.append("Problem ").append(count).append(": ").append(dist[n-1][n-1]).append("\n");
		}
		System.out.println(sb);

	}

}
