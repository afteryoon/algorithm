import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		String str=sc.nextLine().trim();
		StringTokenizer st = new StringTokenizer(str," ");
		
		System.out.println(st.countTokens());
		
	}

}
