

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static List<Integer>[] g;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		g = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) g[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			g[a].add(b);
			g[b].add(a);
		}

		int best = 1;
		int bestSum = Integer.MAX_VALUE;

		for (int s = 1; s <= N; s++) {
			int sum = bfsSum(s);
			if (sum < bestSum || (sum == bestSum && s < best)) {
				bestSum = sum;
				best = s;
			}
		}

		System.out.println(best);
	}

	static int bfsSum(int start) {
		int[] dist = new int[N + 1];
		Arrays.fill(dist, -1);
		ArrayDeque<Integer> q = new ArrayDeque<>();
		dist[start] = 0;
		q.add(start);

		while (!q.isEmpty()) {
			int u = q.poll();
			for (int v : g[u]) {
				if (dist[v] == -1) {
					dist[v] = dist[u] + 1;
					q.add(v);
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] == -1) {
				// 그래프가 분리되어 있을 가능성까지 방어
				return Integer.MAX_VALUE / 4;
			}
			sum += dist[i];
		}
		return sum;
	}
}
