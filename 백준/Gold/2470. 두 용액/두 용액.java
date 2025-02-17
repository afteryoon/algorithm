
import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	public static void main(String[] args ) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		System.out.print(search());
	}

	public static String search() {
		int left = 0;
		int right = arr.length-1;
		int al = 0, ar =0, min = Integer.MAX_VALUE;
		while(left < right) {
			int sum = arr[left]+ arr[right];

			if(Math.abs(min) > Math.abs(sum)) {
				min = sum;
				al = arr[left];
				ar = arr[right];
			}

			if(sum < 0) 	left++;
			else 			right--;

		}

		return al + " " + ar;
	}
}
