import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s2908();
		
	}
	public void s2908() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		String n1=st.nextToken();
		String n2=st.nextToken();
		
		n1=rster(n1);
		n2=rster(n2);
		String answer=Integer.parseInt(n1)>Integer.parseInt(n2)?n1:n2;
		System.out.println(answer);
	}
	public String rster(String str) {
		String[] arr=str.split("");
		String reverse="";
		for(int i=arr.length-1; i>=0; i--) 
			reverse+=arr[i];

		return reverse;
	}
}