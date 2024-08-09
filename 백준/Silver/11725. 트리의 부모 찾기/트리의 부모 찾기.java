import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	//백준 11725 dfs s2
	//

	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] parent;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		parent = new int[n+1];
		visited = new boolean[n+1];

		for (int i = 1; i <= n ; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[y].add(x);
			graph[x].add(y);
		}

		dfs(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= n; i++) {
			sb.append(parent[i]).append('\n');
		}
		System.out.print(sb);

	}

	public static void dfs(int node){
		visited[node] = true;
		for (int i : graph[node]){
			if (!visited[i]){
				parent[i]=node;
				dfs(i);
			}
		}
	}
}
