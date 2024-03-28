import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s1546();
		
	}
	public void s1546() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		double [] arr=new double[n];
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		double sum=0;
		
		for (int i = 0; i < n; i++) 
			arr[i]=Double.parseDouble(st.nextToken());
		
		double max=Arrays.stream(arr).max().getAsDouble();
		for (int i = 0; i < arr.length; i++) {
			arr[i]=setScore(arr[i],max);
			sum+=arr[i];
		}
		sum/=n;
		System.out.println(sum);
	}
	public double setScore(double num, double max) {
		double avg = ((double)Math.round((num / max) * 10000) ) / 100;
		return avg;
	}
}