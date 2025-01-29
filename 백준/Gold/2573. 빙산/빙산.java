
import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] graph;
	static int x, y;
	static boolean[][] isVisit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		graph = new int[x][y];

		for(int i = 0; i < x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < y; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		while(true) {
			int count = check();
			if(count >= 2) break;
			if(count == 0) {
				result = 0;
				break;
			}
			result++;
			year();
		}

		System.out.print(result);
	}

	private static int check() {
		isVisit = new boolean[x][y];
		int count = 0;
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(graph[i][j] != 0 && !isVisit[i][j]) {
					count++;
					dfs(i, j);
				}
			}
		}
		return count;
	}

	private static void dfs(int i, int j) {
		isVisit[i][j] = true;

		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx >= 0 && nx < x && ny >= 0 && ny < y &&
				graph[nx][ny] != 0 && !isVisit[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}

	private static void year() {
		int[][] temp = new int[x][y];
		for(int i = 0; i < x; i++) {
			System.arraycopy(graph[i], 0, temp[i], 0, y);
		}

		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(graph[i][j] != 0) {
					melt(i, j, temp);
				}
			}
		}

		graph = temp;
	}

	private static void melt(int i, int j, int[][] temp) {
		for(int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if(nx >= 0 && nx < x && ny >= 0 && ny < y &&
				graph[nx][ny] == 0 && temp[i][j] > 0) {
				temp[i][j]--;
			}
		}
	}
}