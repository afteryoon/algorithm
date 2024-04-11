
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
/*
 * 백준 1927 최소힙
 * 메모리
 * 시간
 */
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb= new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			int cmd= Integer.parseInt(br.readLine());
			if(cmd==0) {
				int pop=pq.isEmpty()?0:pq.poll();
				sb.append(pop+"\n");
			}else {
				pq.offer(cmd);
			}
		}
		
		System.out.println(sb);
		
	}

}
