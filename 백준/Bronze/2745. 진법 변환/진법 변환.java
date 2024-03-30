import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		String str=st.nextToken();
		int n=Integer.parseInt(st.nextToken());
		int sum=0;
		
		for (int i = 0; i < str.length(); i++) {
			char ch=str.charAt(str.length()-1-i);
			int num;
			if(ch>='A' && ch<='Z') 
				num=(ch-55);
			else
				num=ch-'0';
			sum+=num*(Math.pow(n,i));
			
		}
		
		System.out.println(sum);
		
	}
}
