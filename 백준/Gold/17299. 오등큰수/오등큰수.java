
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
/*
 * 17299 오등큰수 G3
 * 메모리
 * 시간
 * 시간복잡도
 * 
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		int[] arr=new int[n];
		Map<Integer, Integer> map= new HashMap<Integer, Integer>();
 		StringTokenizer st= new StringTokenizer(br.readLine());
 		
 		for (int i = 0; i < n; i++) {
			 arr[i]=Integer.parseInt(st.nextToken());
			 //몇개가 나왔는지 카운트할 map
			 map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
 		
 		Stack<Integer> stack = new Stack<>();
 		for (int i = 0; i < arr.length; i++) {
 			//stack에 있는 값 (오등큰수가 없던 값의 누적 값)<(arr[i]의 카운트 값 비교)
			while(!stack.isEmpty() && map.get(arr[stack.peek()])<map.get(arr[i])) {
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
