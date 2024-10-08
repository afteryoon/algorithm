import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s10816_h();
		
	}
	public void s10816_h() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			String key =st.nextToken();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			String key =st.nextToken();
			sb.append(map.getOrDefault(key, 0)).append(' ');
		}
		
		System.out.println(sb);
	}
}