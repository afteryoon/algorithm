

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * ATM 
	 * 메모리
	 * 시간
	 * 
	 * 시간복잡도
	 * 
	 * 문제
	 * 처음 주어지는 사람의 수 k
	 * k를 내림차순으로 정렬
	 * 각 시간을 더한 값을 총 시간값에 더해줌
	 * 
	 */
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	
		int k= Integer.parseInt(br.readLine());
		int[] arr = new int[k];

		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		for (int i = 0; i <k; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int minWaiting=0;
		int add=0;
		for (int i = 0; i < arr.length; i++) {
			add+=arr[i];
			minWaiting+=add;
		}
		
		System.out.println(minWaiting);
			
	}
}
