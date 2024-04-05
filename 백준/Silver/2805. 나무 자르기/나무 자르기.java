

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 2805 번 나무 자르기
 * 시간
 * 메모리
 * 시간 복잡도
 * 
 * 설명
 * 나무 M개가 필요
 * 높이 H
 * 한줄에 있는 나무 H부분을 모두 자름
 * 최소한으로 가져갈 높이를 정하기
 * 
 * 최대로 정할 수 있는 높이는 배열의 max값
 * 상근이는 집에 필요한 나무를 항상 가져갈 수 있다.
 * ->나머지 값들의 합이 m이면? 
 * 
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st= new StringTokenizer(br.readLine()," ");
		
		int k= Integer.parseInt(st.nextToken());
		int m= Integer.parseInt(st.nextToken());
		
		long[] arr= new long[k];
		st= new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i <k; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		long start=1;
		long end= Arrays.stream(arr).max().getAsLong();
		
		while(start<=end) {
			//절단할 높이
			long mid=(start+end)/2; 
			
			long sum=Arrays.stream(arr)
					//자르는 높이보다 작은 나무는 제외
					.filter(e -> e>mid)
					//나무에서 자른 값들을 합침
					.map(e -> e-mid)
					.sum();
			
			if(sum>=m)
				start=mid+1;
			else
				end=mid-1;
		}
		System.out.println(end);

	}

}
