import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s27160();
		
	}
	public void s27160() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		
		for(int i=0; i<n; i++) {
			int sum=0;
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			String name= st.nextToken();
			int num= Integer.parseInt(st.nextToken());
			
			if(map.containsKey(name))
				map.put(name, map.get(name)+num);
			else
				map.put(name, num);
		}
		
			System.out.println(hallyCheck(map));
		
	}
	
	public String hallyCheck(Map<String, Integer> map) {
		
		for(String key : map.keySet()) {
			if(map.get(key)==5)
				return "YES";
		}
		return "NO";
	}
}