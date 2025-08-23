

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static String nextToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)  return  null;
			st = new StringTokenizer(line);
		}
		return st.nextToken();
	}

	public static void main(String[] args) throws IOException {
		long t = Long.parseLong(nextToken());
		int  n = Integer.parseInt(nextToken());
		Long[] A = new Long[n];
		for (int i = 0; i < n; i++)  A[i] = Long.parseLong(nextToken());

		int m = Integer.parseInt(nextToken());
		Long[] B = new Long[m];
		for (int i = 0; i < m; i++) B[i] = Long.parseLong(nextToken());

		List<Long> aSums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			long sum = 0;
			for (int j = i; j < n; j++) {
				sum += A[j];
				aSums.add(sum);
			}
		}

		List<Long> bSums = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			long sum = 0;
			for (int j = i; j < m; j++) {
				sum += B[j];
				bSums.add(sum);
			}
		}

		Collections.sort(aSums);
		bSums.sort(Collections.reverseOrder());

		int i=0; int j=0;
		long ans = 0;

		while (i < aSums.size() && j < bSums.size()) {
			long s = aSums.get(i) + bSums.get(j);
			if(s == t) {
				long aVal = aSums.get(i);
				long bVal = bSums.get(j);

				long cntA = 0;
				while (i < aSums.size() && aSums.get(i) == aVal) { cntA++; i++; }

				long cntB = 0;
				while (j < bSums.size() && bSums.get(j) == bVal) { cntB++; j++; }

				ans += cntA * cntB;

			} else if (s < t) {
				i++;
			} else {
				j++;
			}
		}

		System.out.println(ans);

	}
}
