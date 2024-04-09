

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 13975 파일 합치기3
 * 
 * 문제
 * T개의 테스트
 * 
 *  첫 행에는 소설을 구성하는 장의 수 K (3 ≤ K ≤ 1,000,000)
 *  1장부터 K장까지 수록한 파일의 크기를 나타내는 양의 정수 K
 *  파일의 크기는 10,000 초과하지 않음
 *  
 *  1,000,000*10,000 (int 범위 초과, Long 필요)
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t=Integer.parseInt(br.readLine()); //test case
		
		for (int i = 0; i < t; i++) {
			
			int k=Integer.parseInt(br.readLine());
			st= new StringTokenizer(br.readLine()," ");
			//큰 수가 누적해서 더해지지 않도록 오름차순 정렬하기 위한 큐
			PriorityQueue<Long> files=new PriorityQueue<>();
			
			//값 대입
			for (int j = 0; j < k; j++) 
				files.offer(Long.parseLong(st.nextToken()));
			
			long answer=0;
			//누적 합을 위해 작은 파일 두개를 더한 값을 더하기 및 q에 추가
			while(files.size()>1) {
				long file=files.poll()+files.poll();
				answer+=file;
				files.offer(file);
			}
			
		System.out.println(answer);	
		}
		
	}

}
