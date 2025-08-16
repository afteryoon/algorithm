

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		int maxLength = 0;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			maxLength = Math.max(maxLength, arr[i]);
			sum += arr[i];
		}

		int left = maxLength;
		int right = sum;
		int ans = right;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if(checkpack(mid)){
				ans = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}

		System.out.println(ans);

	}

	public static boolean checkpack(int mid) {

		int cnt = 1;
		int sum = 0;

		for (int x : arr	) {
			if (sum + x > mid) {
				cnt++;
				sum = x;
				if (cnt > M) return false;
			} else {
				sum += x;
			}
		}

		return true;
	}
}
