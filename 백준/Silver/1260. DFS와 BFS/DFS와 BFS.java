
import java.util.*;
import java.io.*;

public class Main {

	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] isVisited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		isVisited = new boolean[node+1];

		for (int i=0; i<=node; i++) {
			graph.add(new ArrayList<>());
		}

		for(int i=0;i<edge;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);

		}

		for(int i=0; i<=node; i++) {
			Collections.sort(graph.get(i));
		}

		dfs(start);
		sb.append("\n");
		isVisited = new boolean[node+1];
		bfs(start);

		System.out.println(sb);


	}

	public static void dfs(int node) {
		isVisited[node] = true;
		sb.append(node).append(" ");

		for(int next : graph.get(node)) {
			if (!isVisited[next]) {
				dfs(next);
			}
		}

	}

	public static void bfs(int node) {
		isVisited[node] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(" ");
			for (int next : graph.get(cur)) {
				if (!isVisited[next]) {
					isVisited[next] = true;
					queue.add(next);
				}
			}

		}

	}


}
