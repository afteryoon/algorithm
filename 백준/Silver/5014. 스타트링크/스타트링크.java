

import java.util.*;
import java.io.*;

public class Main {
	static int g;
	static int u;
	static int d;
	static int f;
	static int[] visit;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		f = Integer.parseInt(st.nextToken()); // 총 층의 수
		int s = Integer.parseInt(st.nextToken()); // 현재 층 수
		g = Integer.parseInt(st.nextToken()); // 목적지
		u = Integer.parseInt(st.nextToken()); // 위로
		d = Integer.parseInt(st.nextToken()); // 아래
		visit = new int[f+1];

		int result = bfs(s);
		System.out.print(result == -1 ? "use the stairs" : result);
	}

	public static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		Arrays.fill(visit,-1);
		visit[n] = 0;

		int count = 0;
		while (!q.isEmpty()) {
			int current = q.poll();
			if(current == g)
				return visit[current];
			int[] move = {current+u,current-d};
			for (int i=0; i<2; i++){
				int ny= move[i];
				if(ny <= f && ny>0 && visit[ny] == -1){
					visit[ny] = visit[current]+1;
					q.add(ny);
				}
			}
		}

		return -1;
	}
}
