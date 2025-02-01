
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args ) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int g = Integer.parseInt(br.readLine());
		Arrays.sort(arr);

		int count =0;
		int left = 0;
		int right = n-1;

		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum == g ) {
				count++;
				left++;
				right--;
			}
			else if (sum<g) left++;
			else right--;
		}

		System.out.print(count);
	}
}
