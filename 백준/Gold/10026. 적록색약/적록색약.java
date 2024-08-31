
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	//10026
	//

	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static char[][] graph;
	static boolean[][] visit;

	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new char[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				graph[i][j] = line.charAt(j);
			}
		}
		StringBuilder sb = new StringBuilder();

		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j]){
					count1++;
					dfs(i,j);
				}
			}
		}
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j]){
					count2++;
					dfs2(i,j);
				}
			}
		}

		System.out.println(count1 + " " + count2);
	}

	private static void dfs(int i,int j){
		visit[i][j] = true;

		for (int k = 0; k < 4; k++) {
			int ny = i+dy[k];
			int nx = j+dx[k];

			if(nx >=0 && ny >=0 && nx<n  && ny< n
			&& !visit[ny][nx] && graph[i][j] == graph[ny][nx]){
				dfs(ny,nx);
			}
		}
	}

	private static void dfs2(int i,int j){
		visit[i][j] = true;


		for (int k = 0; k < 4; k++) {
			int ny = i+dy[k];
			int nx = j+dx[k];

			if(nx >=0 && ny >=0 && nx<n  && ny< n
				&& !visit[ny][nx]){
				if(graph[i][j] =='G' || graph[i][j] =='R' ) {
					if(graph[ny][nx] == 'G' ||graph[ny][nx] == 'R') {
						dfs2(ny, nx);
					}
				}else if(graph[i][j] == 'B' &&  graph[ny][nx] =='B'){
					dfs2(ny, nx);
				}
			}
		}
	}

}
