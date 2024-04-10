

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
/*
 * 백준 좋은 단어 3986 S
 * 메모리
 * 시간
 * 시간복잡도
 * 
 * 문제
 * 
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		int count=0;
		//주어진 test만큼 반복
		for (int i = 0; i < n; i++) {
			//문자를  담을 stack
			Stack<Character> stack = new Stack<>();
			String cmd= br.readLine();
			
			stack.push(cmd.charAt(0)); 
			for (int j = 1; j < cmd.length(); j++) {
				//주어진 단어의 길이가 홀수일 경우 아치를 만들 수 없으므로 return
				if(cmd.length()%2!=0) break; 
				//비교할 값이 있고, 비교할 값과 다음 값이 같으면 아치 성공
				if(!stack.isEmpty()&& stack.peek()==cmd.charAt(j)) {
					stack.pop();
				}else {
					//비교할 값이 없는 아치 시작이거나, 아치를 만들지 못하는 경우 stack에 추가
					stack.push(cmd.charAt(j));
				}
			}
			//아치가 모두 만들어졌을 경우 stack이 비어있음
			if(stack.isEmpty())
				count++;
		}
		
		System.out.println(count);
	}

}
