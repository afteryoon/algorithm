
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine()); //컴퓨터 수
		int M=Integer.parseInt(br.readLine()); //연경된 노드 쌍 개수
		
		//그래프 생성
		for (int i = 0; i <= N; i++) 
			graph.add(new ArrayList<>());
		
		//그래프 정보 입력
		for (int i = 0; i < M; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int a =Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		visited= new boolean[N+1]; //방문 여부 확인
		
		int count=dfs(1);
		System.out.println(count-1); //1자체의 노드는 제외
	}
	//dfs 실행함수
	public static int dfs(int node) {
		int count=1; // 현재 노드를 포함한 카운트
		visited[node]= true; // 현재 노드 방문 표시
		
		 // 현재 노드와 연결된 모든 노드에 대해 DFS 실행
		for(int nextNode : graph.get(node)) {
			if(!visited[nextNode])// 아직 방문하지 않은 노드라면
				count += dfs(nextNode);// DFS 실행 및 카운트 업데이트
		}
		
		
		
		return count;
	}
	
}
