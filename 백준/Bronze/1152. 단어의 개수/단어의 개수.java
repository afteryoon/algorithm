import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s1152();
	
	}
	public void s1152() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine().trim()," ");
		System.out.println(st.countTokens());
	}
}