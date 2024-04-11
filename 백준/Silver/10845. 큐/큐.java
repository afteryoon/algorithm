
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;


public class Main {
/*
 * 10845 큐
 * 메모리
 * 시간
 * 
 */
	public static void main(String[] args) throws  IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new LinkedList<Integer>();
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i <n; i++) {
			String[] arr=br.readLine().split(" ");
			String cmd=arr[0];
			int num=-100;
			if(arr.length>1)
				 num=Integer.parseInt(arr[1]);
			
			switch (cmd) {
				case "push" : 
					q.offer(num); break;
				case "pop" :
					int pop=q.isEmpty()?-1:q.poll();
						sb.append(pop+"\n");
					break;
				case "size" :
					sb.append(q.size()+"\n");	break;
				case "empty":
					int empty=q.isEmpty()?1:0;
					sb.append(empty+"\n");	break;
				case "front":
					int front=q.isEmpty()?-1:q.peek();
					sb.append(front+"\n");	break;
				case "back":
					int back=q.isEmpty()?-1:q.peekLast();
					sb.append(back+"\n"); break;
					
				default:sb.append("오타난듯"+cmd);	break;
			}
		
		}
		
		System.out.println(sb);
	}
	

}
