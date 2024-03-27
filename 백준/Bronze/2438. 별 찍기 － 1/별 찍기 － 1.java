import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.valueOf(br.readLine());
		
		for(int row=1; row<=n; row++) {
			for(int col=0; col<row; col++ ) {
				System.out.print("*");
			}
			System.out.println("");
		}
    }
}