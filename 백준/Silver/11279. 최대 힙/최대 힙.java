

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
/*
 * 11279 최대힙
 * 메모리
 * 시간
 */
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i <n; i++) {
			int num= Integer.parseInt(br.readLine());
			if(num==0) {
				int pop=pq.isEmpty()?0:pq.poll();
				sb.append(pop+"\n");
			}else 
				pq.offer(num);
		}
		
		System.out.println(sb);
		
	}

}
