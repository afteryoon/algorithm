
import java.util.*;
import java.io.*;

public class Main {
	static int r,c;
	static char[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];

		for(int i=0; i<r; i++) {
			String line = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int max = -1;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(map[i][j] == 'L')
					max = Math.max(bfs(i,j),max);
			}
		}
		System.out.print(max);
	}

	public static int bfs(int x,int y) {
		boolean isVisit[][] = new boolean[r][c];
		isVisit[x][y] = true;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y,0});
		int distance = -1;

		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cx = cur[0];
			int cy = cur[1];
			int dist = cur[2];
			distance = Math.max(distance,dist);

			for(int i=0; i<4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(nx<0 || nx >=r || ny < 0 || ny >= c || isVisit[nx][ny] || map[nx][ny] == 'W') continue;
					isVisit[nx][ny] = true;
					q.add(new int[]{nx,ny,dist+1});
			}
		}
		return distance;
	}
}
