

import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int n,l,r;
	static int[][] graph;
	static boolean[][] isVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n =Integer.parseInt(st.nextToken());
		l =Integer.parseInt(st.nextToken());
		r =Integer.parseInt(st.nextToken());
		graph = new int[n][n];

		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int days = 0;

		while(true) {
			isVisit = new boolean[n][n];
			boolean flag = false;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!isVisit[i][j]) {
						if( bfs(i,j) ) flag = true;
					}
				}
			}
			if(!flag)  break;
			days++;
		}

		System.out.print(days);
	}

	public static boolean bfs(int x,int y) {
		isVisit[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		List<int[]> u = new LinkedList<>();
		q.add(new int[]{x,y});
		u.add(new int[]{x,y});

		int total = graph[x][y];

		while(!q.isEmpty()) {

			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];

			for(int i=0; i<4; i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];

				if(nx<0 || nx >= n || ny < 0 || ny >= n || isVisit[nx][ny]) continue;
				int m = Math.abs(graph[cx][cy] - graph[nx][ny]);
				if(m>=l && m<=r ) {
					isVisit[nx][ny] = true;
					q.add(new int[]{nx,ny});
					u.add(new int[]{nx,ny});
					total += graph[nx][ny];
				}
			}

		}

		if(u.size() == 1) return false;
		int union = total/u.size();
		for(int[] un : u) {
			graph[un[0]][un[1]] = union;
		}

		return true;
	}
}
