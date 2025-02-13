

import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[][] map;
	static int[][][] isVisit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //행
		m = Integer.parseInt(st.nextToken()); // 열
		map = new int[n][m];
		isVisit = new int[n][m][2];

		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for (int j=0; j<m; j++) {
				map[i][j] = line.charAt(j) - '0';
				isVisit[i][j][0] = -1;
				isVisit[i][j][1] = -1;
			}
		}
		isVisit[0][0][0] = 1;
		q.add(new int[]{0,0,0}); //행 열 벽사용여부

		while(!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int check = current[2];

			if(x == n-1 && y == m-1) {
				System.out.println(isVisit[x][y][check]);
				return;
			}

			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];

				if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

				if(map[nx][ny] == 1 && check == 0) {
					q.add(new int[] {nx,ny,1});
					isVisit[nx][ny][1] = isVisit[x][y][0]+1;
				} else if(map[nx][ny] == 0 && isVisit[nx][ny][check] == -1 ) {
					q.add(new int[] {nx,ny,check});
					isVisit[nx][ny][check] = isVisit[x][y][check]+1;
				}
			}
		}

		System.out.print(-1);
	}
}
