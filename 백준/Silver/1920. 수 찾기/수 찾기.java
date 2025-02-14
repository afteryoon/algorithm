
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<m; i++) {
			int ni = bs(Integer.parseInt(st.nextToken()));
			sb.append(ni).append("\n");
		}
		System.out.println(sb);
	}

	public static int bs(int n) {
		int left = 0;
		int right = arr.length-1;

		while(left<=right) {
			int mid = (left+right) /2;

			if(arr[mid] == n) return 1;
			else if(arr[mid]>n) right = mid-1;
			else left = mid+1;
		}

		return 0;
	}
}
