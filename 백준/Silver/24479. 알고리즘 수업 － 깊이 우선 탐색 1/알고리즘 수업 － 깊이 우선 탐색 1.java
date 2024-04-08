import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 백준 24479번 알고리즘 수업-깊이우선탐색
	 * 메모리
	 * 시간
	 * 시간 복잡도
	 * 
	 * 문제
	 * N개의 정점, M개의 간선 무방향 그래프
	 * 정점번호 1-N 번 모든 간선의 가중치 1
	 * 정점 R에서 시작하여 깊이 우선 탐색으로 노드 방문할 경우 노드의 방문 순서 출력
	 * 
	 *  테이블 형태로 구현하면 메모리 초과 문제가 발생
	 *  List 형태로 메모리 절약 가능
	 *  
	 */
	 static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 정점들의 정보를 기록할 그래프
	 static int[] visited; // 방문한 정점을 기록할 배열
	 static int count; // 방문 순서
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] input =br.readLine().split(" ");
		
		int vertex=Integer.parseInt(input[0]); //노드의 개수
		int edgeSize=Integer.parseInt(input[1]); //간선의 수
		int r=Integer.parseInt(input[2]); //시작점
		
		//int[][] graph=new int[vertex+1][vertex+1]; 
		
		graph= new ArrayList<>();
		visited= new int[vertex+1];
		
		for (int i = 0; i < vertex+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < edgeSize; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int x= Integer.parseInt(st.nextToken()); //시작 노드
			int y= Integer.parseInt(st.nextToken()); //연결된 노드
			
			//무방향 서로 연결 되어 있음
//			graph[x][y]=1;
//			graph[y][x]=1;
			graph.get(x).add(y);
            graph.get(y).add(x);
		}
		
		for(int i=1;i<graph.size();i++) {
			Collections.sort(graph.get(i));
		}
		
		//정점의 방문 순서는 1
		 count=1;
		dfs(r);
		
		StringBuilder sb= new StringBuilder();

		for (int i = 1; i < visited.length; i++) {
				sb.append(visited[i]+"\n");
		}
		System.out.println(sb);
		
	}
	private static void dfs(
			int start
	) {
		//Stack<Integer> stack = new Stack<>();

		visited[start] = count; //현재 정점 노드 저장
		
		//현재 정점노드의 연결 노드 순회
		for (int i = 0; i < graph.get(start).size(); i++) {
			int vertex=graph.get(start).get(i);
			
			if(visited[vertex]==0) {
				count++;
				dfs(vertex);
			}
		}
		
	}
}
