

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 
 * 메모리
 * 시간
 * -시간복잡도
 * 
 * 
 * n의 정사각형이 주어짐 
 * 이 때 수는 자신의 한칸 아래 수보다 큼
 * 
 * priorityQue에 내림차순 저장
 * n만큼 반복하여 n일 때만 출력
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int j = 0; j <n; j++) 
				pq.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 1; i <=n; i++) {
			if(i==n)
				System.out.println(pq.poll());
			else
				pq.poll();
		}
		
	}
}
