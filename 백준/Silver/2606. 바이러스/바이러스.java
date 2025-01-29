
import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] isVisit;
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int node = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		isVisit = new boolean[node+1];
		graph = new ArrayList<>();

		for ( int i=0; i<=node; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i<edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		System.out.println(dfs(1)-1);
	}

	private static int dfs(int node) {
		isVisit[node] = true;
		int count =1;
		for (int next : graph.get(node)) {
			if(!isVisit[next]) {
				count += dfs(next);
			}
		}
		return count;
	}
}
