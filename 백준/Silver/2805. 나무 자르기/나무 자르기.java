
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] trees = new int[n];
		st = new StringTokenizer(br.readLine());
		int max = 0;
		int min = 1;
		for(int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max,trees[i]);
		}

		long result = 0;
		while(min<=max) {
			int mid = (max+min)/2;
			long tree = 0;
			for(int i=0; i<n; i++) {
				if(trees[i]>mid) {
					tree += trees[i]-mid;
				}
			}

			if(m <= tree) {
				result = mid;
				min = mid+1;
			}else {
				max = mid-1;
			}
		}

		System.out.print(result);
	}
}
