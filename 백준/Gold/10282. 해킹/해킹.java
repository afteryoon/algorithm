

import java.util.*;
import java.io.*;

public class Main {
	static class Com {
		int to;
		int time;

		public Com(int to, int time){
			this.to = to;
			this.time = time;
		}
	}
	static StringBuilder sb= new StringBuilder();
	static List<List<Com>> graph;
	static StringTokenizer st;
	static int n,edge,start;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine());
		for (int test = 0; test<tests; test++) {
			graph = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			edge = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			for(int i=0; i<=n; i++) {
				graph.add(new ArrayList<>());
			}
			for(int i=0; i<edge; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());

				// graph.get(from).add(new Com(to,time));
				graph.get(to).add(new Com(from,time));
			}

			int[] fromStart = dijkstra(start);
			int maxTime = 0;
			int count = 0;
			for(int i=1; i<=n; i++) {
				if(fromStart[i] != Integer.MAX_VALUE) {
					maxTime = Math.max(maxTime,fromStart[i]);
					count++;
				}
			}

			sb.append(count+" "+maxTime+"\n");
		}
		System.out.print(sb);
	}

	public static int[] dijkstra(int start) {
		int[] dist = new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		PriorityQueue<Com> pq = new PriorityQueue<>((a,b)->a.time - b.time);
		pq.add(new Com(start,0));
		dist[start] = 0;

		while(!pq.isEmpty()) {
			Com cur = pq.poll();
			int curCom = cur.to;
			int curTime = cur.time;

			if(curTime > dist[curCom]) continue;

			for(Com next : graph.get(curCom)) {
				int nextCom = next.to;
				int nextTime = curTime + next.time;
				if (nextTime < dist[nextCom]) {
					dist[nextCom] = nextTime;
					pq.add(new Com(nextCom, nextTime));
				}
			}
		}

		return dist;
	}
}
