
import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int[] result;
	static boolean[] isUse;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		result = new int[n+1];
		isUse = new boolean[n+1];

		backtrack(0);

		System.out.print(sb);
	}

	public static void backtrack(int depth) {
		if(depth == m) {
			for(int i = 0; i<m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i<=n; i++) {
			if(!isUse[i]) {
				isUse[i] = true;
				result[depth] = i;
				backtrack(depth+1);
				isUse[i] = false;
			}
		}

	}
}
