
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			int n= Integer.parseInt(br.readLine());
			
			Stack<Integer> s = new Stack<Integer>();
			StringBuilder sb= new StringBuilder();
			for (int i = 0; i <n; i++) {
				String[] arr=br.readLine().split(" ");
				String cmd=arr[0];
				int num=-100;
				if(arr.length>1)
					 num=Integer.parseInt(arr[1]);
				
				switch (cmd) {
					case "push" : 
						s.push(num);		break;
					case "pop" :
						int pop=s.isEmpty()?-1:s.pop();
							sb.append(pop+"\n");
						break;
					case "size" :
						sb.append(s.size()+"\n");	break;
					case "empty":
						int empty=s.isEmpty()?1:0;
						sb.append(empty+"\n");	break;
					case "top":
						int top=s.isEmpty()?-1:s.peek();
						sb.append(top+"\n");	break;
					
					default:sb.append("오타난듯"+cmd);	break;
				}
			
			}
			
			System.out.println(sb);
		}
		

	}
