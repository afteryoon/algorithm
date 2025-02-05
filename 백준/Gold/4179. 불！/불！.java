
import java.io.*;
import java.util.*;

public class Main {
	static char[][] map;
	static int[] dx = {0,0,-1,1}; //행 이동
	static int[] dy = {1,-1,0,0}; //열 이동
	static Queue<int[]> q = new LinkedList<>();
	static Queue<int[]> f = new LinkedList<>();
	static int r,c;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); //행
		c = Integer.parseInt(st.nextToken()); //열
		int[][] dist = new int[r][c];
		map = new char[r][c];

		for(int i=0; i<r; i++) {
			char[] temp = br.readLine().toCharArray();
			for(int j=0; j<c; j++) {
				map[i][j] = temp[j];
				dist[i][j]=-1;
				if(map[i][j] == 'J') {
					q.add(new int[] {i,j});
					dist[i][j]=1;
				}else if (map[i][j] == 'F') {
					f.add(new int[] {i,j});
				}
			}
		}

		while(!q.isEmpty()) {
			if(!f.isEmpty()){
				int size = f.size();
				for(int i=0; i<size; i++){
					fmove();
				}
			}

			int jmove= q.size();
			for(int move=0; move<jmove; move++){
				int[] current = q.poll();

				for(int i=0; i<4; i++) {
					int nx = current[0]+dx[i];
					int ny = current[1]+dy[i];

					if(nx<0 || nx>=r || ny<0 || ny>=c) {
						System.out.print(dist[current[0]][current[1]]);
						return;
					}
					char next = map[nx][ny];
					if(next == '.' && dist[nx][ny] ==-1 ) {
						q.add(new int[]{nx,ny});
						dist[nx][ny] = dist[current[0]][current[1]]+1;
					}
				}
			}
		}
		System.out.print("IMPOSSIBLE");
	}

	public static void fmove(){
		int[] current = f.poll();
		int cx = current[0];
		int cy = current[1];

		for(int i=0; i<4; i++) {
			int nx = cx + dx[i];
			int ny = cy + dy[i];

			if(nx>=0 && nx<r && ny>=0 && ny<c &&
				map[nx][ny]=='.'){
				f.add(new int[] {nx,ny});
				map[nx][ny] = 'F';
			}
		}
	}
}
