
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s1157();
		
	}
	public void s1157() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine().toUpperCase();
		int[] count= new int [28];
		int check=0;
		int result=0;
		for(int i=0; i<str.length(); i++) 
			count[str.charAt(i)-'A']++;
		int max=Arrays.stream(count).max().getAsInt();
		
		for (int i = 0; i < count.length; i++) {
			if(max==count[i]) {
				result=i;
				check++;
			}
			if(check==2) 
				break;
		}
		
		char answer=check==2?'?':(char)('A'+result);
		System.out.println(answer);
	}
}