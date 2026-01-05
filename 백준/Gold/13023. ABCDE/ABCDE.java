

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] isVisit;
	static int node,edge;

	public static void main(String[] args) throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st =new StringTokenizer(br.readLine());
	node = Integer.parseInt(st.nextToken());
	edge = Integer.parseInt(st.nextToken());

	for (int i = 0; i < node; i++) {
		graph.add(new ArrayList<>());
	}
	isVisit = new boolean[node];

	for (int i = 0; i < edge; i++) {

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		graph.get(a).add(b);
		graph.get(b).add(a);

	}

	for (int s = 0; s < node; s++) {
	    java.util.Arrays.fill(isVisit, false);
	    if (dfs(s, 1)) {
	        System.out.println(1);
	        return;
	    }
	}
	System.out.println(0);

	}

	static boolean dfs(int u, int depth) {
	    if (depth == 5) return true; 
	    isVisit[u] = true;
	    for (int v : graph.get(u)) {
	        if (!isVisit[v]) {
	            if (dfs(v, depth + 1)) return true;
	        }
	    }
	    isVisit[u] = false; 
	    return false;
	}

}
