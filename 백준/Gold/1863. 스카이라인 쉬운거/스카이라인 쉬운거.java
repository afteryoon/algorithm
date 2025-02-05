
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st;
		int result = 0;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			while(!stack.isEmpty() && stack.peek() > y){
				result++;
				stack.pop();
			}

			if(!stack.isEmpty() && stack.peek() == y) continue;
			stack.push(y);
		}

		while(!stack.isEmpty()){
			if(stack.peek() !=0) result++;
			stack.pop();
		}

		System.out.print(result);
	}
}
