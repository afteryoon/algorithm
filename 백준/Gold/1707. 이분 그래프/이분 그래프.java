
import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static StringBuilder sb = new StringBuilder();
	static int[] isVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int test=0; test<n; test++ ) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			isVisit = new int[node+1];
			for(int i=0; i<=node; i++) {
				graph.add(new ArrayList<>());
			}

			for(int i=0; i<edge; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				graph.get(from).add(to);
				graph.get(to).add(from);
			}
			boolean flag = true;
			for(int i=1; i<=node; i++) {
				if(isVisit[i] == 0) {
					if(!dfs(i,1)) {
						flag = false;
						break;
					}
				}
			}
			sb.append(flag? "YES" : "NO").append("\n");
		}

		System.out.print(sb);
	}

	public static boolean dfs(int node , int visit) {
		isVisit[node] = visit;

		for(int next : graph.get(node)) {
			if(isVisit[next] == 0) {
				if(!dfs(next,-visit)) {
					return false;
				}
			}else if(isVisit[next] == visit){
				return false;
			}
		}
		return true;
	}
}
