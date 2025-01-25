

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][][] graph;
	static int[] moveX = {1,-1,0,0,0,0};
	static int[] moveY = {0,0,-1,1,0,0};
	static int[] moveZ = {0,0,0,0,1,-1};
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		graph = new int[h][n][m];

		for(int k = 0; k < h; k++) {
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					graph[k][i][j] = Integer.parseInt(st.nextToken());
					if(graph[k][i][j] == 1) {
						q.add(new int[]{k,i,j});
					}
				}
			}
		}

		int day = bfs();
		boolean check = true;
		for(int k = 0; k < graph.length; k++) {
			for(int i = 0; i < graph[k].length; i++) {
				for(int j = 0; j < graph[k][i].length; j++) {
					if(graph[k][i][j] == 0) {
						check = false;
						break;
					}
				}
			}
		}
		System.out.println(check ? day : -1);

	}

	private static int bfs() {
		int days = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			days++;
			for(int i = 0; i < size; i++) {
				int[] cur = q.poll();
				for(int j = 0; j < 6; j++) {  // 6방향 탐색
					int nz = cur[0] + moveZ[j];
					int nx = cur[1] + moveX[j];
					int ny = cur[2] + moveY[j];

					if(nx >= 0 && nx < graph[0].length &&
						ny >= 0 && ny < graph[0][0].length &&
						nz >= 0 && nz < graph.length &&
						graph[nz][nx][ny] == 0) {
						graph[nz][nx][ny] = 1;
						q.add(new int[]{nz,nx,ny});
					}
				}
			}
		}
		return days;
	}
}
