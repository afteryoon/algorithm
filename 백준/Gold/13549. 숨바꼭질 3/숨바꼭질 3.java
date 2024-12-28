

import java.util.*;
import java.io.*;

public class Main {
	static class Node {
		int move;
		int time;

		Node(int move, int time) {
			this.move = move;
			this.time = time;
		}
	}

	static int[] dist = new int[100001];  // 각 위치까지의 최소 시간을 저장
	static int k;
	static PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time - b.time);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		System.out.println(bfs(n));
	}

	public static int bfs(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (curr.move == k) {
				return curr.time;
			}

			if (curr.time > dist[curr.move]) continue;

			if (curr.move * 2 <= 100000 && curr.time < dist[curr.move * 2]) {
				dist[curr.move * 2] = curr.time;
				pq.offer(new Node(curr.move * 2, curr.time));
			}

			// 걷기
			if (curr.move + 1 <= 100000 && curr.time + 1 < dist[curr.move + 1]) {
				dist[curr.move + 1] = curr.time + 1;
				pq.offer(new Node(curr.move + 1, curr.time + 1));
			}

			if (curr.move - 1 >= 0 && curr.time + 1 < dist[curr.move - 1]) {
				dist[curr.move - 1] = curr.time + 1;
				pq.offer(new Node(curr.move - 1, curr.time + 1));
			}
		}

		return dist[k];
	}
}