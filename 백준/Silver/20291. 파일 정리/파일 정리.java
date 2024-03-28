import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s20291();
		
	}
	public void s20291() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine(),".");
			String name=st.nextToken();
			String type=st.nextToken();
			
			if(map.containsKey(type)) 
				map.put(type, map.get(type)+1);
			else
				map.put(type, 1);
		}
		ArrayList<String> al= new ArrayList<>(map.keySet());
		Collections.sort(al);
		for(String key : al) {
			System.out.println(key+ " " + map.get(key));
		}
		
	}
}