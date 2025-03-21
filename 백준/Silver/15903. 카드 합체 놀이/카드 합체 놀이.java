import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long sum = 0;

		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			long card = Long.parseLong(st.nextToken());
			pq.add(card);
			sum+=card;
		}

		for(int i=0; i<m; i++) {
			long mix = pq.poll() +pq.poll();
			sum+= mix;
			pq.add(mix);
			pq.add(mix);
		}

		System.out.print(sum);
	}
}
