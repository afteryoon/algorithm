import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int node;
	static int edge;
	static boolean[] isVisited;
	static List<List<Integer>> graph;
	static StringBuilder sb = new StringBuilder();
	static int order = 1;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		isVisited = new boolean[node+1];
		visited = new int[node+1];

		for (int i = 0; i <= node; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i =1; i <= node; i++) {
			graph.get(i).sort(Collections.reverseOrder());
		}

		dfs(start);

		for (int i = 1; i <= node; i++) {
			sb.append(visited[i]).append("\n");
		}

		System.out.print(sb);
	}

	public static void dfs(int currentNode) {
		isVisited[currentNode] = true;
		visited[currentNode] = order++;

		for (int next : graph.get(currentNode)) {
			if (!isVisited[next]) {
				dfs(next);
			}
		}
	}


}
