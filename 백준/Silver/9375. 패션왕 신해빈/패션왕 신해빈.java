
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * 
 * 한번 입었던 조합은 다시 입지 않음,
 * 옷의 종류가 중복되게 입을 수 없음
 * 
 * 옷의 종류의 갯수를 확인 
 * 
 */
public class Main {
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test= Integer.parseInt(br.readLine());
		Map<String,Integer> map;
		StringTokenizer st;
		
		for (int i = 0; i < test; i++) {
			
			map = new HashMap<>();
			int n= Integer.parseInt(br.readLine());
			
			for (int j = 0; j < n; j++) {
				st= new StringTokenizer(br.readLine());
				String name=st.nextToken();
				String type=st.nextToken();
				
				map.put(type, map.getOrDefault(type, 1)+1);
			}
			
			int total=1;
			
			for(String key : map.keySet()) {
				total*=  (map.get(key));
			}
				
			System.out.println(total-1);
		}
	}
}
