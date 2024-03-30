import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char mid=0;
	public static void main(String[] args)throws IOException {
		int[] count = new int[26];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String str=br.readLine();
		
		for (int i = 0; i < str.length(); i++) 
			count[str.charAt(i)-'A']++;
		
		StringBuilder sb= new StringBuilder();
		if(check(count)) {
			for (int i = 0; i < count.length; i++) {
				for (int j = 0; j < count[i]/2; j++) 
					sb.append((char)(i+'A'));
			}
            
			if(mid!=0)
			sb.append(mid);
			
			for (int i = 25; i >=0; i--) {
				for (int j = 0; j < count[i]/2; j++) 
					sb.append((char)(i+'A'));
			}
			System.out.println(sb);
		}else {
			sb.append("I'm Sorry Hansoo");
			System.out.println(sb);
		}
		
	}
	
	public static boolean check(int[] count) {
		int check=0;
		int sum=0;
		for (int i = 0; i < count.length; i++) {
			if(count[i]%2!=0) {
				mid=(char)(i+'A');
				check++;
			}
			
			if(check==2)
				return false;
			
			sum++;
		}
		if(sum%2!=0 && check==1)
			return false;
		
		
		return true;
	}
}
