
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 백준 1863 스카이라인 쉬운거 G4
 * 메모리
 * 시간
 * 시간복잡도
 * 
 * 문제
 * 높이가 낮아질 때 마다 건물이 추가되는 것을 알 수 있음, -> 건물이 낮아지면 pop
 * 같은 높이일 땐 stack에 추가할 필요 없음
 */
public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		//건물 수를 셀 count
		int count=0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			//건물이 낮아지면 건물 추가, 높은 건물 pop
			while(!stack.isEmpty() && stack.peek()>y) {
				count++;
				stack.pop();
			}
			//같은 높이라면 추가할 필요 없음(길게 이어질 수 있기 때문에)
			if(!stack.isEmpty() && stack.peek()==y)		continue;
			//stack이 비어있거나 stack의 y값보다 큰 경우
			stack.push(y);
		}
		
		while(!stack.isEmpty()) {
			//x는 1부터 시작하므로 0보다 클 때만 count 해야함
			if(stack.peek() >0) count++;
			stack.pop();
		}
			
		System.out.println(count);
	}

}
