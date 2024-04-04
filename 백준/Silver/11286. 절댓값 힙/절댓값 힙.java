

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * 시간
 * 메모리
 * -시간 복잡도
 * 
 * pq가 비어있으면 0을 출력
 * 아니면 절대값이 가장 적은 수를 출력
 * 
 */
public class Main {

	public static void main(String[] args)throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());

		var comparator= new MyComparator();
		
		PriorityQueue<Integer> pq= new PriorityQueue<>(comparator);
		
		//메소드내 정의시
//		PriorityQueue<Integer> pq= new PriorityQueue<>(new  Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				if(Math.abs(o1)==Math.abs(o2))
//					return o1-o2;
//				else 
//					return Math.abs(o1)-Math.abs(o2);
//			}
//		});
		
		for (int i = 0; i < n; i++) {
			
			int x= Integer.parseInt(br.readLine());
			if(x==0) {
				int answer= pq.isEmpty() ?0:pq.poll();
				System.out.println(answer);
			}else {
				pq.offer(x);
			}
			
		}
	}
	
	//함수화 시켜 정의시
	static class MyComparator implements Comparator<Integer>{
		@Override
		public int compare(Integer o1, Integer o2) {
			if(Math.abs(o1)==Math.abs(o2))
				return o1-o2;
			else 
				return Math.abs(o1)-Math.abs(o2);
		}
	}

}
