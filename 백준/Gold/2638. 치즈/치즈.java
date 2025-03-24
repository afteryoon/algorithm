
import java.util.*;
import java.io.*;

public class Main {
	static int[][] map;
	static boolean[][] isVisit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,m;
	static Queue<int[]> q;
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		while(true) {
			q = new LinkedList<>();
			isVisit = new boolean[n][m];
			dfs(0,0);
			if(q.isEmpty()) {
				break;
			}
			count++;
			melt();
		}
		System.out.print(count);
	}

	public static void melt() {

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int count = 0;

			for(int d=0; d<4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx<0 || nx >= n || ny<0 || ny >= m) continue;
				if(isVisit[nx][ny] && map[nx][ny] == 0) {
					count++;
				}
				if(count>=2) {
					map[x][y] = 0;
				}
			}

		}

	}

	public static void dfs(int x,int y) {
		isVisit[x][y] = true;

		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];

			if(nx<0 || nx >= n || ny<0 || ny >= m) continue;
			if(!isVisit[nx][ny]) {
				if(map[nx][ny] == 1) {
					q.add(new int[]{nx,ny});
				}else {
					dfs(nx,ny);
				}
			}
		}
	}
}
