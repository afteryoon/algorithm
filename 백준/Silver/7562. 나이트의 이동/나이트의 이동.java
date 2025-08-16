

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int cx;
	static int cy;

	static int[] dx = {-2,-1, 1, 2, 2, 1,-1,-2};
	static int[] dy = { 1, 2, 2, 1,-1,-2,-2,-1};

	static int[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//test 개수
		int testCases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test = 0; test < testCases; test++) {
			//한 변의 길이
			int length = Integer.parseInt(br.readLine());
			visited = new int[length][length];
			for (int i=0; i<length; i++) {
				Arrays.fill(visited[i], -1);
			}

			StringTokenizer st;
			st = new StringTokenizer(br.readLine());
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int gx = Integer.parseInt(st.nextToken());
			int gy = Integer.parseInt(st.nextToken());

			Queue<int[]> q = new LinkedList<>();
			visited[cx][cy] = 0;
			q.add(new int[] {cx, cy});

			while (!q.isEmpty()) {
				int[] cur = q.poll();

				if (cur[0] == gx && cur[1] == gy) {
					break;
				}

				for (int i=0; i<dx.length; i++) {
					int nx = cur[0] + dx[i];
					int ny = cur[1] + dy[i];

					if(nx<length && nx>=0 && ny<length && ny>=0 && visited[nx][ny] == -1) {
						visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
						q.add(new int[] {nx, ny});
					}
				}

			}
			sb.append(visited[gx][gy]).append("\n");
		}
		System.out.println(sb);
	}
}
