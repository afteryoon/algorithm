
import java.io.*;
import java.util.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] isVisit;
	static int result,compare = 0;
	static List<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();

		for (int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i=1; i<=n; i++) {
			int to = Integer.parseInt(br.readLine());
			graph.get(i).add(to);
		}

		for(int i=1; i<=n; i++) {
			isVisit = new boolean[n+1];
			compare = i;
			dfs(i);
		}

		StringBuilder sb = new StringBuilder();
		sb.append(result).append("\n");

		Collections.sort(list);

		for(int i : list) {
			sb.append(i).append("\n");
		}

		System.out.print(sb);
	}

	public static void dfs(int node){

		for(int next : graph.get(node)) {
			if(next == compare) {
				list.add(compare);
				result++;
				return;
			}else if(!isVisit[next]){
				isVisit[next] = true;
				dfs(next);
			}
		}

	}
}
