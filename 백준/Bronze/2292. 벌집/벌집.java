import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		//6의 배수로 면이 증가 함

		int count = 1;
		int range = 1;
		while (range < n) {
			range = range +(count * 6);
			count++;
		}

		System.out.println(count);
	}
}

