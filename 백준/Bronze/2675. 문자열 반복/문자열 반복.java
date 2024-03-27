import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s2675();
	
	}
	public void s2675() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.valueOf(br.readLine());
		
		for(int i=0; i<n; i++) {
			String p="";
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int r= Integer.valueOf(st.nextToken());
			String str=st.nextToken();
			
			for(int j=0; j<str.length(); j++) {
				for(int j2=0; j2<r; j2++) {
					p+=str.charAt(j);
				}
			}
			
			System.out.println(p);
		}
		
	}
}