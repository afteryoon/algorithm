
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;
	
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge o) {
		return this.weight-o.weight;
	}
}
public class Main {
/*
 * 1197 최소 스패닝 트리 mst
 * 메모리
 * 시간
 * 
 */
	static int[] parents;
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int vertex= Integer.parseInt(st.nextToken());
		int edge= Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> al = new ArrayList<>();
		for(int i=0; i<edge; i++) {
			 st= new StringTokenizer(br.readLine());
			 int from=Integer.parseInt(st.nextToken());
			 int to=Integer.parseInt(st.nextToken());
			 int weight=Integer.parseInt(st.nextToken());
			 al.add(new Edge(from, to, weight));
		}
		
		Collections.sort(al);
		
		parents= new int [vertex+1];
		for (int i = 1; i <= vertex; i++) {
			parents[i]=i;
		}
		
		int sum=0;
		for(Edge elem : al) {
			if(union(elem.from,elem.to))
				sum+=elem.weight;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(sum);
		System.out.println(sum);

	}
	private static int find(int node) {
		if(parents[node]==node)
			return node;
		//재기 사용 하여 부모를 찾음
		return parents[node]=find(parents[node]);
	}
	
	private static boolean union(int from , int to) {
		from= find(from);
		to= find(to);
		
		if(from==to) //같은 부모인경우 싸이클이 됨
			return false;
		
		parents[to]=from; //간선 연결되었으면 부모 설정
		return true;
	}

}
