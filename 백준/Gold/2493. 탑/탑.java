
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i=n-1; i>=0; i--) {

			while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
				arr[stack.pop()] = i+1;
			}
			stack.push(i);
		}

		while(!stack.isEmpty()) {
			arr[stack.pop()] = 0;
		}

		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+" ");
		}

		System.out.println(sb);

	}
}
