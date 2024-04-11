
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
/*
 * 백준 2161 카드1
 * 메모리
 * 시간
 * 
 */
	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <=n; i++) 
			q.offer(i);
		
		
		StringBuilder sb= new StringBuilder();
		while(q.size()>1) {
			sb.append(q.poll()+" ");
			q.offer(q.poll());
		}
		
		sb.append(q.poll());
		
		System.out.println(sb);
	}

}
