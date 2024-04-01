import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException{
		Queue<String> que = new LinkedList();
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		for (int i = 0; i <n; i++) 
			que.offer(br.readLine());
		
		int count=0;
		
		for (int i = 0; i < n; i++) {
			String cn=br.readLine();
			String check=que.peek();
			if(cn.equals(check)) {
				que.poll();
			}else {
				que.remove(cn);
				count++;
			}
		}
		System.out.println(count);
	}
}
