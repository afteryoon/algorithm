

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0, right = n-1;
		int result = Integer.MAX_VALUE;
		int r1 =0 , r2 =0 ;
		
		while(left < right) {
			int sum = arr[left] + arr[right];

			if(Math.abs(sum) < Math.abs(result)) {
				result = sum;
				r1 = arr[left];
				r2 = arr[right];
			}

			if(sum < 0) left++;
			else right--;
		}

		System.out.print(r1 + " " + r2);
	}
}
