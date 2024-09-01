

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	//1987

	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	static char[][] board;
	static boolean[] visit= new boolean[26];
	static int x,y;
	static int maxCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		y= Integer.parseInt(st.nextToken());
		x= Integer.parseInt(st.nextToken());
		board = new char[y][x];

		for (int i = 0; i < y; i++) {
				board[i]=br.readLine().toCharArray();
		}
		dfs(0,0,1);
		System.out.println(maxCount);
	}

	private static void dfs(int i, int j,int count) {
		visit[board[i][j]-'A']=true;
		maxCount = Math.max(maxCount, count);

		for (int k = 0; k < 4; k++) {
			int ny = i + dy[k];
			int nx = j + dx[k];
			if(ny>=0 && nx>=0 && ny<y && nx<x && !visit[board[ny][nx]-'A']){
				dfs(ny,nx,count+1);
			}
		}

		visit[board[i][j] - 'A'] = false;
	}
}
