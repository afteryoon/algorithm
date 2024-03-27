import java.util.*;
public class Main {
	public static void main(String[] args){
		
		Main main = new Main();
		
		main.s2445();
	
	}
	public void s2445(){
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		for (int row = 1; row <= n; row++) {
			
			for (int col = 0; col <row; col++) 
				System.out.print("*");
			
			for(int col=(n*2)-(row*2); col>0; col-=1) 
				System.out.print(" ");
			
			for (int col = 0; col <row; col++) 
				System.out.print("*");
			
			System.out.println();
		}
			for(int row=1; row<n; row++) {
				for(int col=n; col>row; col--) 
					System.out.print("*");
				
				for(int col=0; col<row*2; col++)
					System.out.print(" ");
				
				for(int col=n; col>row; col--) 
					System.out.print("*");
				
				System.out.println();
			}
		
	}
}