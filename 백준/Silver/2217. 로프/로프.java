
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int min = 10000;
		int max = 0;
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			min =Math.min(min,arr[i]);
			max =Math.max(max,arr[i]);
		}

		Arrays.sort(arr);

		int k = 0;
		for (int i=0; i<n; i++) {
			k= Math.max(k, arr[i]*(n-i));
		}

		System.out.print(k);
	}
}
