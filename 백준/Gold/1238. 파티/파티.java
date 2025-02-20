

import java.io.*;
import java.util.*;

public class Main {
	public static class Node {
		int to;
		int time;

		public Node ( int to, int time) {
			this.to = to;
			this.time = time;
		}

	}
	static List<List<Node>> graph = new ArrayList<>();
	static boolean[] isVisit;
	static int n,m,x;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		for(int i=0; i<=n; i++) graph.add(new ArrayList<>());

		for(int i = 0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			graph.get(from).add(new Node(to,time));
		}

		int result = 0;

		for (int i=1; i<=n; i++) {
			int temp = dijkstra(i,x) + dijkstra(x,i);
			result = Math.max(result,temp);
		}

		System.out.print(result);
	}

	public static int dijkstra(int start, int end) {
		int[] dist= new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time-b.time);
		pq.offer(new Node(start,0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int from = cur.to;
			int time = cur.time;

			if(dist[from] < cur.time) continue;

			for (Node next : graph.get(from)) {
				if(dist[next.to]>next.time+dist[from]) {
					dist[next.to]=next.time + dist[from];
					pq.add(new Node(next.to,next.time));
				}
			}
		}

		return dist[end];
	}

}
