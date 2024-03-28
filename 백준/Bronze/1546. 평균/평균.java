
import java.util.*;

public class Main {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		
		double a= sc.nextDouble();
		sc.nextLine();
		String[] n= sc.nextLine().split(" ");
		double[] arr= new double[n.length];
		
		double max=arr[0];
		double result=0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i]= Integer.valueOf(n[i]);
			if(max<arr[i])
				max=arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			result+= arr[i]/max;
		}
		
		System.out.printf("%.2f",((result)/a)*100);
		
	
			
	}
}
