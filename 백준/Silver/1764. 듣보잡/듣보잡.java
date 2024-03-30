
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <(n+m); i++) {
			String name=br.readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
		}
		StringBuilder sb= new StringBuilder();
		
		int count=0;
		for(String key : map.keySet()) {
			if(map.get(key)==2) {
				sb.append(key).append("\n");
				count++;
			}
		}
		sb.insert(0, count +"\n");
		System.out.println(sb);
	}
}
