
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			String p="";
			String[] s=sc.nextLine().split(" ");
			int r=Integer.valueOf(s[0]);
			for (int j = 0; j < s[1].length(); j++) {
				for (int j2 = 0; j2 < r; j2++) 
						p+=s[1].charAt(j);
			}
			
			System.out.println(p);
		}
		
	}
}
