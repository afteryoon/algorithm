import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s10773();
	
	}
	public void s10773() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n= Integer.valueOf(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n; i++) {
			int x=Integer.valueOf(br.readLine());
			if(x==0) {
				stack.pop();
			}else {
				stack.push(x);
			}
		}
		int answer=0;
		for(int elem : stack) {
			answer+=elem;
		}
		
		System.out.println(answer);
		
	}
}