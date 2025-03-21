
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //심사대
		int m = Integer.parseInt(st.nextToken()); //인원

		long[] arr = new long[n];

		long left = 1;
		long right = 0;

		for(int i=0; i<n; i++) {
			arr[i] = Long.parseLong(br.readLine());
			right = Math.max(arr[i],right);
		}
		Arrays.sort(arr);
		right = right * m;

		while(left<=right) {
			long mid = (left + right) / 2;
			long count = 0 ;

			for(long l : arr) {
				count += mid / l;
				if(count >= m) break;
			}

			if( count >= m) {
				right = mid -1;
			} else {
				left = mid +1;
			}
		}

		System.out.print(left);
	}
}
