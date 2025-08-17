

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int lenLines = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		long right = 0;
		long left = 1;
		long ans = 0;

		int[] arr = new int[lenLines];
		for (int i = 0; i < lenLines; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		while (left <= right) {
			long mid = left + ( right - left) / 2;

			long count = Arrays.stream(arr)
				.mapToLong(x ->x/mid)
				.sum();

			if (count >= goal) {
				ans = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}

		}

		StringBuilder sb = new StringBuilder();
		sb.append(ans);
		System.out.println(sb);
	}
}
