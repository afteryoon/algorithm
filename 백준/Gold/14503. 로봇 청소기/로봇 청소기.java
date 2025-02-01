
import java.util.*;
import java.io.*;

public class Main {
	static int[][] graph;
	static int[] dx = {-1, 0, 1, 0};  
	static int[] dy = {0, 1, 0, -1};
	static int x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		graph = new int[x][y];
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < y; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.print(dfs(sx, sy, d));
	}

	public static int dfs(int i, int j, int direction) {
		int count = 0;

		if(graph[i][j] == 0) {
			graph[i][j] = 2;
			count = 1;
		}

		int originalDir = direction;
		for(int k = 0; k < 4; k++) {
			direction = (direction + 3) % 4;
			int nx = i + dx[direction];
			int ny = j + dy[direction];

			if(nx >= 0 && nx < x && ny >= 0 && ny < y && graph[nx][ny] == 0) {
				return count + dfs(nx, ny, direction);
			}
		}

		int back = (originalDir + 2) % 4;
		int bx = i + dx[back];
		int by = j + dy[back];

		if(bx >= 0 && bx < x && by >= 0 && by < y && graph[bx][by] != 1) {
			return count + dfs(bx, by, originalDir);
		}

		return count;
	}
}