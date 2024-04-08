
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 백준 24444 알고리즘 수업 - 너비 우선 탐색 1
	 * 메모리 
	 * 시간
	 * 시간복잡도
	 * 
	 * 문제
	 * 너비 우선 탐색(BFS) 수업
	 * N개의 정점과 M개의 간선  - 무방향 그래프(undirected graph)
	 * 정점 번호는 1번부터 N번이고 모든 간선의 가중치는 1
	 * 정점 R에서 시작하여 너비 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력
	 * 
	 * 
	 */
	 static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
	 static int[] visited; // 방문한 정점을 기록할 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] input =br.readLine().split(" ");
		
		int vertex=Integer.parseInt(input[0]); //노드의 개수
		int edgeSize=Integer.parseInt(input[1]); //간선의 수
		int r=Integer.parseInt(input[2]); //시작점

		graph= new ArrayList<>();
		visited= new int[vertex+1];
		
		for (int i = 0; i < vertex+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edgeSize; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int x= Integer.parseInt(st.nextToken()); //시작 노드
			int y= Integer.parseInt(st.nextToken()); //연결된 노드
			
			graph.get(x).add(y);
            graph.get(y).add(x);
		}
		
		for(int i=1;i<graph.size();i++) {
			Collections.sort(graph.get(i));
		}
		//넓이 탐색 메서드
		bfs(r);
		
		StringBuilder sb= new StringBuilder();
		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]+"\n");
		}
		
		System.out.println(sb);
	}
	
	private static void bfs(
			int start
	) {
		Queue<Integer> q = new LinkedList<>();
		int count=1;
		//정점 노드 offer
		q.offer(start);
		//1번 인덱스에 정점 노드 대입
		visited[start]=count++;
		
		while(!q.isEmpty()) {
			int front=q.poll(); //상위노드
			//연결노드 병렬 탐색
			for (int i = 0; i < graph.get(front).size(); i++) {
				int vertex = graph.get(front).get(i);
				//방문 체크
				if(visited[vertex] !=0) 
					continue;
				//queue에 하위 노드 offer
				q.offer(vertex);
				//하위노드 대입
				visited[vertex]=count++;
			}
		}
	}

}
