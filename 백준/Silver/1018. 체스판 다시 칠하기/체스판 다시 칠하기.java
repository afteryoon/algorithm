

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());

	        char[][] board = new char[N][M];

	        for (int i = 0; i < N; i++) {
	            String row = br.readLine();
	            for (int j = 0; j < M; j++) {
	                board[i][j] = row.charAt(j);
	            }
	        }

	        int min = Integer.MAX_VALUE;

	        // 아래와 오른쪽이 8개 이상 있는 시작점들의 체크
	        for (int i = 0; i <= N - 8; i++) {
	            for (int j = 0; j <= M - 8; j++) {
	            	//시작점을 매개변수로 주어 검사
	            	min = Math.min(min, count(board, i, j));
	            }
	        }

	        System.out.println(min);
	    }

	    // 바꿔야 하는 칸이 몇개인지 확인하는 메소드
	    private static int count(char[][] board, int x, int y) {
	        char color = board[x][y];  
	        int count = 0;
	        
	        for (int i = x; i < x+8; i++) {
				for (int j = y; j <y+8; j++) {	
					if(color!=board[i][j]) {
						count++;
					}
					color=(color == 'W') ? 'B' : 'W';
				}
				color=(color == 'W') ? 'B' : 'W';
			}
	        count=Math.min(count, 64-count);
	        return count;
	    }
	}