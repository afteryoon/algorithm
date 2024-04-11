

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 2606 바이러스 dfs
 * 메모리	
 * 시간		
 * 
 */
	static ArrayList<Integer>[] al;
	static boolean[] visited;
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int m= Integer.parseInt(br.readLine());
		al= new ArrayList[n+1];
		for (int i = 1; i <=n; i++) {
			al[i]=new ArrayList<>();
		}
		
		for (int i = 0; i <m; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int node=Integer.parseInt(st.nextToken());
			int edge=Integer.parseInt(st.nextToken());
			al[node].add(edge);
			al[edge].add(node);
		}
		
		visited= new boolean[n+1];
		int count=dfs(1);
		
		StringBuilder sb= new StringBuilder();
		//1번 빼기
		sb.append(count-1);
		System.out.println(sb);
	}
	
	private static int dfs(int root) {
		int count=1;
		visited[root]=true;

		for(int next : al[root]) {
			//방문하지 않았으면 탐색
			if(!visited[next]) 
				count+=dfs(next);
		}
		
		return count;
	}

}
