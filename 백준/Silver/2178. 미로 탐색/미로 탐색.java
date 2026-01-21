

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int row,col;
	static char[][] graph;
	static int[] dx = {-1, 0, 1, 0}; // 상.우,하,좌
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		graph = new char[row][col];
		isVisited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0, 1});
		isVisited[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0], cy = cur[1], dist = cur[2];

			if (cx == row - 1 && cy == col - 1) {
				System.out.println(dist);
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nx = cx + dx[k], ny = cy + dy[k];
				if (nx >= 0 && nx < row && ny >= 0 && ny < col
						&& graph[nx][ny] == '1' && !isVisited[nx][ny]) {
					isVisited[nx][ny] = true; 
					q.add(new int[]{nx, ny, dist + 1});
				}
			}
		}

		System.out.println(0);
	}


}
