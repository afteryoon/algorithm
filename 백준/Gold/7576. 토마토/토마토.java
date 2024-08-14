
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	//7576 백준
	static int[][] graph;
	static int[] dx = {-1,0,0,1}; //x축
	static int[] dy = {0,1,-1,0}; //y축
	static int m,n;
	static Queue<int[]> que = new LinkedList<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //가로
		n = Integer.parseInt(st.nextToken()); //세로
		graph = new int[n][m];
		int check = 0 ;

		for (int i = 0; i < n; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				int state = Integer.parseInt(st.nextToken());
				if(state ==1 )
					que.offer(new int[]{i,j,0});

				if (state == 0)
					check++;

				graph[i][j] = state;
			}
		}

		if (check == 0){
			System.out.println(0);
			return;
		}

		int result = bfs(check);
		System.out.println(result);

	}

	static int bfs(int count ){
		int days = 0;
		while (!que.isEmpty()) {
			int[] arr = que.poll();
			int day = arr[2];
			days = Math.max(days, day);

			for (int i = 0; i < 4; i++) {
				int ny =arr[0]+dy[i]; //y좌표 (세로)
				int nx =arr[1]+dx[i]; //x좌표 (가로)

				if(ny>=0 && nx>=0 && ny<n && nx<m && graph[ny][nx] == 0){
					graph[ny][nx] = 1;
					que.offer(new int[]{ny, nx,day+1});
					count--;
				}
			}
		}

		return count == 0 ? days : -1;
	}
}
