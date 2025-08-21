

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		//조카의 수
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());  // 막대 과자 수

		int[] arr = new int[n];
		long right = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right = Math.max(right, arr[i]);
		}

		long left = 1;
		long ans = 0L;


		while (left <= right) {
			long mid = left + (right - left) / 2;
			long count = Arrays.stream(arr).mapToLong(x -> x / mid).sum();
			if (count >= k) {
				ans = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}

		sb.append(ans);
		System.out.println(sb);

	}
}
