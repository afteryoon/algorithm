
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/*
	 * ATM 
	 * 
	 * 메모리 
	 * 시간 
	 * 
	 * O(NlogN)일 때
	 * 메모리 14384
	 * 시간 132
	 * 
	 * 시간복잡도
	 * 
	 * 문제
	 * 처음 주어지는 사람의 수 k
	 * k를 내림차순으로 정렬
	 * 각 시간을 더한 값을 총 시간값에 더해줌
	 * +수정 후
	 * 최대값을 기준으로 분수 별로 배열에 저장
	 * 분수 별로 더하여 최대 값을 구함
	 * 
	 */
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int k= Integer.parseInt(br.readLine());
		//최대시간인 1001분을 기준으로 잡음
		
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int[] arr = new int[1001];
		//몇분이 몇개인지 저장
		for (int i = 0; i <k; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		int prev = 0;	// 대기시간 누적합
		int sum = 0;	// 대기시간 총합
		
		
		for (int i = 1; i <1001 ; i++) {
			
			while (arr[i]-- > 0) {
				// 이전까지의 대기시간과 현재 사람이 걸리는 시간을 더해준다.
				sum += (i + prev);
				// 이전까지의 누적합에 현재 걸리는 시간을 더해준다.
				prev += i;
			}
		}
		
		System.out.println(sum);
			
	}

}
