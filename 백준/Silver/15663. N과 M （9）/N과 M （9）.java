
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[] arr, result;
	static boolean[] isUse;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		result = new int[n];
		isUse = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		backtracking(0);

		System.out.print(sb);
	}

	public static void backtracking(int depth) {
		if(depth == m) {
			for (int i=0; i<m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		int prev = 0;
		for(int i=0; i<n; i++) {
			if(!isUse[i] && prev != arr[i]) {
				isUse[i] = true;
				result[depth] = arr[i];
				prev = arr[i];
				backtracking(depth+1);
				isUse[i] = false;
			}
		}
	}
}
