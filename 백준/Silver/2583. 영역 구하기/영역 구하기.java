
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] graph;
	static boolean[][] visit;

	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static int y,x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		y= Integer.parseInt(st.nextToken());
		x= Integer.parseInt(st.nextToken());
		int t= Integer.parseInt(st.nextToken());

		graph = new int[y][x];
		visit = new boolean[y][x];

		for (int i = 0; i < t; i++) {
			st= new StringTokenizer(br.readLine());

			int nx1 = Integer.parseInt(st.nextToken());
			int ny1 = Integer.parseInt(st.nextToken());
			int nx2 = Integer.parseInt(st.nextToken());
			int ny2 = Integer.parseInt(st.nextToken());

			for (int j = ny1; j < ny2; j++) {
				for (int k = nx1; k < nx2; k++) {
					graph[j][k]=1;
				}
			}
		}
		int count=0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				if(!visit[i][j] && graph[i][j]==0){
					count++;
					pq.add(dfs(i,j));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n");
		while (!pq.isEmpty())
			sb.append(pq.poll()).append(" ");

		System.out.println(sb);


	}

	public static int dfs(int h, int w){
		visit[h][w]=true;
		int count =1;
		for (int i = 0; i < 4; i++) {
			int nx = w+dx[i];
			int ny = h+dy[i];
			if (nx>=0 && ny>= 0 && nx<x && ny<y && graph[ny][nx]==0 && !visit[ny][nx]){
				count += dfs(ny, nx);
			}
		}

		return count;
	}
}
