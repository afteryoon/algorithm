

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 *  수신한 탑의 번호를 출력
 *  타워의 개수 n
 *  타워들의 높이
 *  
 *  첫번째 타워는 0 고정
 *  타워보다 높은 타워가 없으면 0
 *  높이를 
 *  
 */
public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(br.readLine());
		Stack<int[]> stack= new Stack<>();
		
		StringBuilder sb= new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <=n; i++) {
			int height=Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {
				sb.append("0 ");
				 stack.add(new int[] {i, height});
			}else {
				stack.add(new int[] {i, height});
				while(true) {
					
					if(stack.isEmpty()) {
						sb.append("0 ");
						 stack.push(new int[] {i, height});
						 break;
					}
					int tower[]=stack.peek();
					if(tower[1]>height) {
						sb.append(tower[0]+" ");
						stack.add(new int[] {i,height});
						break;
					}else {
						stack.pop();
					}
				}
			}
		}
		System.out.println(sb);
	}
}
