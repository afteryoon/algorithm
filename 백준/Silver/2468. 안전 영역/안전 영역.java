
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//백준 2468 s1

	static List<Integer>[] graph;
	static boolean[][] visited;
	static int max =1;
	static int min =100;
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int n,simulation;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();


		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int height = Integer.parseInt(st.nextToken());
				max = Math.max(height, max);
				min = Math.min(height,min);
				graph[i].add(height);
			}
		}

		int answer = 1;
		for ( simulation = min-1; simulation < max; simulation++) {
			int count = 0;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(graph[i].get(j)>simulation && !visited[i][j]){
						dfs(i,j);
						count++;
					}
				}
			}

			answer =Math.max(answer,count);
		}

		System.out.println(answer);
	}

	public static void dfs(int x, int y){
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx >=0 && nx < n && ny >= 0 && ny <n &&
				graph[nx].get(ny) > simulation && !visited[nx][ny]){
				dfs(nx,ny);
			}
		}
	}
}
