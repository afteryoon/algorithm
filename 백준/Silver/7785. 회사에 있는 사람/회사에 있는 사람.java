
import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		
		Main main = new Main();
		
		main.s7785();
		
	}
	public void s7785() throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n= Integer.parseInt(br.readLine());
		HashMap<String, String> map = new HashMap<String, String>();
	
		for (int i = 0; i < n; i++) {
			StringTokenizer st= new StringTokenizer(br.readLine()," ");
			String name=st.nextToken();
			String state=st.nextToken();
			if (map.containsKey(name)) {
				map.remove(name);
			} else {
				map.put(name, state);
			}
		}
		ArrayList<String> al = new ArrayList<String>(map.keySet());
		Collections.sort(al,Collections.reverseOrder());
		for(String elem : al)
			System.out.println(elem);
		
	}
}