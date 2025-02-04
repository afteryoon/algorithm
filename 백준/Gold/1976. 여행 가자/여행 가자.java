
import java.util.*;
import java.io.*;

public class Main {
	static List<List<Integer>> graph;
	static boolean[] isVisit;
	static int to;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int node = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for (int i=0; i<=node; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i=1; i<=node; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=node; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1){
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}
		int[] arr = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i=1; i<m; i++) {
			isVisit = new boolean[node+1];
			to = arr[i];
			int start = arr[i-1];
			if(!dfs(start)) {
				System.out.print("NO");
				return;
			}
		}
		System.out.print("YES");
	}

	public static boolean dfs(int from) {
		isVisit[from] = true;
		if(from == to)
			return true;

		for(int next : graph.get(from)) {
			if(!isVisit[next]) {
				if(dfs(next)) return true;
			}
		}

		return false;
	}
}
