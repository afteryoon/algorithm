import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class  Main{
	
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		String[] arr=str.split("-");
		StringBuilder sb= new StringBuilder();
		Arrays.stream(arr)
				.map(s -> s.charAt(0))
				.forEach(sb::append);
		
		System.out.println(sb);
		
	}
}
