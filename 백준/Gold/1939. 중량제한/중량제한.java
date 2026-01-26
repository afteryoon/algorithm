

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Bridge {
		int to;
		int weight;
		Bridge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	static class State implements Comparable<State> {
		int node;
		int cap;
		State(int node, int cap) { this.node = node; this.cap = cap; }
		@Override public int compareTo(State o) { return Integer.compare(o.cap, this.cap); }
	}
	static List<List<Bridge>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int node = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= node; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < edge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Bridge(to, weight));
			graph.get(to).add(new Bridge(from, weight));
		}
		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		PriorityQueue<State> pq = new PriorityQueue<>();
		boolean[] isVisited = new boolean[node + 1];
		pq.add(new State(start, Integer.MAX_VALUE));

		while (!pq.isEmpty()) {
			State cur = pq.poll();
			int u = cur.node;
			int cap = cur.cap;
			if (isVisited[u]) continue;
			isVisited[u] = true;
			if (u == end) {
				System.out.println(cap);
				return;
			}
			for (Bridge e : graph.get(u)) {
				if (!isVisited[e.to]) {
					int ncap = Math.min(cap, e.weight);
					pq.add(new State(e.to, ncap));
				}
			}
		}
		
	}

}
