
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	//백준 2468 s1

	static boolean[][] visited;
	static List<Integer>[] graph;
	static int[] dx = {-1,-1,-1,0,0,1,1,1};
	static int[] dy = {-1,0,1,1,-1,-1,0,1};
	static int row;
	static int col;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();

		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken()); // 너비
			col = Integer.parseInt(st.nextToken()); // 높이

			if(row == 0 && col ==0 ) break;

			visited = new boolean[col][row];
			graph = new ArrayList[col];

			for (int i = 0; i < col; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < col; i++) {
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()){
					int x = Integer.parseInt(st.nextToken());
					graph[i].add(x);
				}
			}
			int count=0;
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					if(graph[i].get(j)==1 && !visited[i][j]){
						dfs(i,j);
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}

	static public void dfs(int x, int y){
		if (visited[x][y]) return;
		visited[x][y] = true;

		for (int i = 0; i < 8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx >=0 && nx <col && ny<row && ny>=0 &&
				graph[nx].get(ny) == 1 && !visited[nx][ny])
				dfs(nx,ny);
		}
	}
}
