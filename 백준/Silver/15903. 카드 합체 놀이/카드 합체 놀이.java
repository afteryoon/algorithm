import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 *시간
 *메모리
 *
 *-시간복잡도
 *
 *문제 추론
 *
 *
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st= new StringTokenizer(br.readLine()," ");
		int size=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq= new PriorityQueue<>();
		st= new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i <size; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		
		for (int i = 0; i < n; i++) {
			long min= pq.poll() + pq.poll();
			
			pq.add(min);
			pq.add(min);
		}
		
		Long sum=0L;
		
		while(!pq.isEmpty()) 
			sum+=pq.poll();
		
		System.out.println(sum);
	}
}
