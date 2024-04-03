import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		Deque<int[]> deque = new ArrayDeque<>();
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		for (int i = 1; i<= n; i++) 
			deque.offer(new int[] {i,Integer.parseInt(st.nextToken())} );
		
		StringBuilder sb= new StringBuilder();
		sb.append("1 ");
	
		int move=deque.poll()[1];

		while(!deque.isEmpty()) {
			
			if(move>0) {
				
				for (int i = 1; i < move; i++) 
					deque.offer(deque.poll());
				int[] next=deque.poll();
				move=next[1];
				sb.append(next[0]+ " ");
			}
			
			else {
				for (int i = 1; i <- move; i++) 
					deque.offerFirst(deque.pollLast());
				int[] next = deque.pollLast();
				move=next[1];
				sb.append(next[0]+ " ");
			}
		}
		System.out.println(sb);
		
	}
	
	

}
