
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 17298 G4
 * 메모리
 * 시간
 * 시간복잡도
 * 
 * 문제
 * N인 수열 A = A1, A2, ..., AN
 *  Ai에 대해서 오큰수 NGE(i)
 * 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수
 * 그러한 수가 없는 경우에 오큰수는 -1
 */
public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n= Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		//원본배열
		int[] arr= new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			//배열에 값 넣기
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		//값 비교
		for (int i = 0; i <n; i++) {
			//이전에 작은 값들 초기화
			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				arr[stack.pop()]=arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			arr[stack.pop()]=-1;
		}
		
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+" ");
		}
		
		System.out.println(sb);
	}
}
