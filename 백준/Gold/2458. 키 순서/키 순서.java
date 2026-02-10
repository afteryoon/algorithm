

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.text.html.ListView;

public class Main {
	static List<List<Integer>> greater = new ArrayList<>();
	static List<List<Integer>> lesser = new ArrayList<>();
	static boolean[] isVisit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= node; i++) {
			greater.add(new ArrayList<>());
			lesser.add(new ArrayList<>());
		}

		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			greater.get(a).add(b);
			lesser.get(b).add(a);
		}

		int answer = 0;
		for (int i = 1; i <= node; i++) {
			isVisit = new boolean[node+1];
			int g = dfs(i,greater);
			isVisit = new boolean[node+1];
			int l = dfs(i,lesser);
			if(g+l == node-1) answer++;
		}

		System.out.println(answer);

	}

	public static int dfs(int node, List<List<Integer>> graph) {
		isVisit[node] = true;
		int count = 0;

		for (Integer next : graph.get(node)) {
			if(!isVisit[next]) {
				count += dfs(next,graph)+1;
			}
		}

		return count;
	}
}
