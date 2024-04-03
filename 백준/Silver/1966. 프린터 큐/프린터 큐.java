

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
 
public class Main {
	static LinkedList<int[]> que;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스 
 
		while (T-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m= Integer.parseInt(st.nextToken());
			
			que= new LinkedList<>();	// Queue로 활용 할 연결리스트
			
			st = new StringTokenizer(br.readLine());
 
			for (int i = 0; i < n; i++) {
				// {초기 위치, 중요도}
				que.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}
 
			sb.append(getCount(m)).append('\n');
 
		}
		System.out.println(sb);
	}
	
	public static int getCount(int M) {
		int count =0;
		
		while (!que.isEmpty()) {	// 한 케이스에 대한 반복문
			
			//첫번째 queue 를 담는 변수
			int[] frist = que.poll();	
			// frist가 가장 큰 원소인지를 판단하는 변수
			boolean flag = true;	
			

			for(int i = 0; i < que.size(); i++) {
				
				// first 보다 큰 값이 있는지 확인
				if(frist[1] < que.get(i)[1]) {
					
					// 큰 값 이전의 값들을 뒤로 보낸다.
					que.offer(frist);
					for(int j = 0; j < i; j++) {
						que.offer(que.poll());
					}
					
					// 첫번째 원소가 가장 큰 값이 아니면 탈출
					flag = false;
					break;
				}
			}
			
			// 중요도가 가장 높은 것인지 체크
			if(flag == false) continue;

			// 출력될 때마다 count
			count++;
			//초기에 저장해둔 인덱스 값 m과 같으면 탈출
			if(frist[0] == M) break;
			
		}
		
		return count;
	}
 
}