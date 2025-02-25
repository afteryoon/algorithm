
import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int to;
		int dist;
		public Node (int to,int dist) {
			this.to = to;
			this.dist = dist;
		}
	}
	static List<List<Node>> graph;
	static boolean[] isVisit;
	static int farthestNode,maxDistance;
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int v = Integer.parseInt(br.readLine());
		graph = new ArrayList<>();
		for(int i=0; i<=v; i++) {
			graph.add(new ArrayList<>());
		}
		StringTokenizer st;
		for (int i=1; i<=v; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int dist = Integer.parseInt(st.nextToken());
				graph.get(from).add(new Node(to,dist));
			}
		}

		// 1단계: 임의의 노드(여기서는 1)에서 가장 먼 노드 찾기
		//트리에서 임의의 노드 X에서 가장 먼 노드 A는 반드시 트리 지름의 한쪽 끝점
		isVisit = new boolean[v+1];
		farthestNode = 0;
		maxDistance = 0;

		dfs(1, 0);

		// 2단계: 가장 먼 노드에서 다시 가장 먼 노드까지의 거리 찾기
		isVisit = new boolean[v+1];
		maxDistance = 0;

		dfs(farthestNode, 0);

		System.out.print(maxDistance);
	}

	public static void dfs(int current , int distance) {
		isVisit[current] = true;

		if(distance > maxDistance) {
			maxDistance = distance;
			farthestNode = current;
		}

		for(Node next : graph.get(current)) {
			if(!isVisit[next.to]) {
				dfs(next.to, distance + next.dist);
			}
		}

	}
}
