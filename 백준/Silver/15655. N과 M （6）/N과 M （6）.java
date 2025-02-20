

import java.io.*;
import java.util.*;

public class Main {

	static int n,m;
	static int[] arr,result;
	static boolean[] isUse;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		isUse = new boolean[n];
		result = new int[m];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		backtrack(0,0);

		System.out.print(sb);
	}

	public static void backtrack(int depth, int start){
		if(depth == m ) {
			for(int i=0; i<m; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=start; i<n; i++) {
			int num = arr[i];

			if(!isUse[i] ) {
				isUse[i] = true;
				result[depth] = arr[i];
				backtrack(depth+1,i+1);
				isUse[i] = false;
			}
		}
	}
}
