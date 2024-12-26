

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] arg) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
		}
		for (int i = 1; i <= n; i++) {
			if (i == n) {
				System.out.println(pq.poll());
			}else
				pq.poll();
		}

	}
}
