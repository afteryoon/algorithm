
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] distances = new long[n-1];
		long[] prices = new long[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n-1; i++) {
			distances[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			prices[i] = Long.parseLong(st.nextToken());
		}

		long minPrice = prices[0];
		long totalPrice = 0;

		for (int i = 0; i < distances.length; i++) {
			if(minPrice>prices[i]) minPrice=prices[i];
			totalPrice += minPrice*distances[i];
		}

		System.out.println(totalPrice);
	}

}
