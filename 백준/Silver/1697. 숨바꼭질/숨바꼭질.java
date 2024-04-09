
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 1697 숨바꼭질
 * 메모리
 * 시간 
 * 시간복잡도
 * 
 * 문제
 * 	현재 점 N(0 ≤ N ≤ 100,000)
 * 동생은 점 K(0 ≤ K ≤ 100,000)
 * 
 * 1초 후에 X-1 또는 X+1
 * 순간이동을 하는 경우에는 1초 후에 2*X
 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성
 * 
 */
	static int n,k;
	static int[] visited;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new  StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		visited= new int[100001]; //최대 좌표
		
		System.out.println(bfs()) ;
		
	}
	
	public static int bfs() {
		
		q.add(n);
		visited[n]=0;
		
		while(!q.isEmpty()) {
			int now=q.poll();
			
			if(now==k) return visited[now];
			
			check(now-1,now);
			check(now+1,now);
			check(now*2,now);
			
		}	
	
		return 0; // 못찾은 경우
	}
	//조건 확인 좌표값 내에 있고, 방문하지 않은 경우
	public static void check(int nx,int now) {
		if(0<=nx && nx<=100000 && visited[nx]==0) {
			q.add(nx);
			visited[nx]=visited[now]+1;
		}
	}

}
