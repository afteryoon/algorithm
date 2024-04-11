

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 1158번 요세푸스 문제
 * 메모리
 * 시간
 * 시간 복잡도
 * 
 * 문제
 * 1번부터 N번까지 N명의 사람이 원  (1 ≤ K ≤ N ≤ 5,000)
 * K번째 사람을 제거
 *  N명의 사람이 모두 제거될 때까지 계속
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <=n; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			
			for (int i = 0; i < k-1; i++) {
				q.offer(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		
		System.out.println(sb);
		
	}

}
