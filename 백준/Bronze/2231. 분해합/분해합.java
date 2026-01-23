

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 생성자 M은 보통 n - (9 * 자릿수) ~ n 범위만 보면 충분
		int len = String.valueOf(n).length();
		int start = Math.max(1, n - 9 * len);

		int ans = 0;
		for (int m = start; m <= n; m++) {
			int sum = m + sumDigits(m);
			if (sum == n) {
				ans = m; // 가장 작은 생성자
				break;
			}
		}

		System.out.println(ans);
	}

	static int sumDigits(int x) {
		int s = 0;
		while (x > 0) {
			s += x % 10;
			x /= 10;
		}
		return s;
	}
}
