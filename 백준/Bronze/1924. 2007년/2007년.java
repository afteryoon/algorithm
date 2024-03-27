import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s1924_2();
	
	}
	public void s1924_2() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int m=Integer.valueOf(st.nextToken());
		int d=Integer.valueOf(st.nextToken());
		int days=0;
		int[] month= {31,28,31,30,31,30,31,31,30,31,30,31};
		String[] day= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		
			for(int i=0; i<m-1; i++) 
				days+=month[i];
		
		days=days+d;
		
		System.out.println(day[days%7]);
		
		
	}
}