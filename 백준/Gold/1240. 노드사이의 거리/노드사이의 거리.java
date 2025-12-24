

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int to;
		int dist;
		public Node(int to,int dist) {
			this.to = to;
			this.dist = dist;
		}
	}

	static List<List<Node>> graph;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodes = Integer.parseInt(st.nextToken());
		int rows = Integer.parseInt(st.nextToken());

		graph = new ArrayList<>();
		// isVisited = new boolean[nodes+1];
		for (int i = 0; i <= nodes; i++) {
			graph.add(new ArrayList<>());

		}

		for(int i = 1; i < nodes; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b,c));
			graph.get(b).add(new Node(a,c));

		}

		StringBuilder sb  = new StringBuilder();

		for (int i = 0; i < rows; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			isVisited = new boolean[nodes+1];
			int ans = dfs(a,b,0);
			sb.append(ans).append("\n");

		}

		System.out.println(sb);

	}

	static int dfs(int start, int end, int dist) {
		if(start == end) return dist;

		isVisited[start] = true;

		for(Node node : graph.get(start)) {
			if(!isVisited[node.to]) {
				int res = dfs(node.to,end,dist+node.dist);
				if(res != 0) return res;
			}
		}

		return 0;
	}


}
