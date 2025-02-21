

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];

		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		int result = Integer.MAX_VALUE;
		int left =1, right = arr[n-1]-arr[0];

		while(left<=right) {
			int mid = (right+left)/2;
			int count = 1;
			int last = arr[0];
			boolean flag =false;

			for(int i=1; i<n; i++) {
				if(arr[i] - last >= mid) {
					count++;
					last = arr[i];

					if(count>=c) {
						flag = true;
					}
				}
			}

			if(flag) {
				result = mid;
				left = mid +1;
			}else {
				right = mid-1;
			}

		}

		System.out.print(result);
	}
}
