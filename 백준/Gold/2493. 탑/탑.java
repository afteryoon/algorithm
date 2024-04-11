
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
/*
 * 백준 2493 탑 stack
 * 메모리
 * 시간
 * 시간 복잡도
 * 
 * 문제
 * 일직선 위에 N개의 높이가 서로 다른 탑
 * 송신 받은  탑의 index+1 출력
 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int[] arr= new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i <n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		for (int i = n-1; i >= 0; i--) {

			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				arr[stack.pop()]=i+1;
			}
			
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
			arr[stack.pop()]=0;
		}
		
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+" ");
		}
		
		System.out.println(sb);
		
	}

}
